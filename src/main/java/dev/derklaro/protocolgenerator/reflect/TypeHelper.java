/*
 * This file is part of mc-protocol-generator, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2023 Pasqual K. and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package dev.derklaro.protocolgenerator.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.StringJoiner;
import lombok.NonNull;

/**
 * This class was originally written for <a
 * href="https://github.com/derklaro/aerogel/blob/e180593d412408754ab20b341d7ba5dbace09686/src/main/java/dev/derklaro/aerogel/internal/reflect/TypeUtil.java">aerogel</a>
 * and was modified for usage with Java 17.
 */
public final class TypeHelper {

  private TypeHelper() {
    throw new UnsupportedOperationException();
  }

  public static @NonNull String toPrettyString(@NonNull Type type) {
    switch (type) {
      case Class<?> clazz -> {
        // check if the class is enclosed
        var enclosingClass = clazz.getEnclosingClass();
        if (enclosingClass != null) {
          var prettyEnclosingClass = toPrettyString(enclosingClass);
          return prettyEnclosingClass + '$' + clazz.getSimpleName();
        } else {
          // top level class
          return clazz.getSimpleName();
        }
      }
      case ParameterizedType parameterizedType -> {
        var infoBuilder = new StringBuilder();

        // append the info about the raw type
        var rawPretty = toPrettyString(parameterizedType.getRawType());
        infoBuilder.append(rawPretty);

        // append the type arguments
        var typeArguments = parameterizedType.getActualTypeArguments();
        if (typeArguments.length > 0) {
          var argumentJoiner = new StringJoiner(", ", "<", ">");
          for (var typeArgument : typeArguments) {
            var argumentPretty = toPrettyString(typeArgument);
            argumentJoiner.add(argumentPretty);
          }
          infoBuilder.append(argumentJoiner);
        }

        return infoBuilder.toString();
      }
      case WildcardType wildcardType -> {
        // check the lower bounds of the wildcard type
        var lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length > 0) {
          var prettyBound = toPrettyString(lowerBounds[0]);
          return "? super " + prettyBound;
        }

        // check the upper bounds of the type
        var upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 0 || upperBounds[0] == Object.class) {
          return "?";
        } else {
          var prettyBound = toPrettyString(upperBounds[0]);
          return "? extends " + prettyBound;
        }
      }
      case GenericArrayType genericArrayType -> {
        // get the info about the component type
        var prettyComponentType = toPrettyString(genericArrayType.getGenericComponentType());
        return prettyComponentType + "[]";
      }
      case TypeVariable<?> typeVariable -> {
        // get the raw type of the bounds
        var bounds = typeVariable.getBounds();
        var prettyBound = toPrettyString(bounds.length == 0 ? Object.class : bounds[0]);

        // append the name of the variable as well
        return prettyBound + " " + typeVariable.getName();
      }
      default -> {
        // unknown type, just return the toString value
        return type.toString();
      }
    }
  }
}
