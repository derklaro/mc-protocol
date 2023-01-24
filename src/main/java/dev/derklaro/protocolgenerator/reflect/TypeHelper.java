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
    if (type instanceof Class<?> clazz) {
      // check if the class is enclosed
      Class<?> enclosingClass = clazz.getEnclosingClass();
      if (enclosingClass != null) {
        String prettyEnclosingClass = toPrettyString(enclosingClass);
        return prettyEnclosingClass + '$' + clazz.getSimpleName();
      } else {
        // top level class
        return clazz.getSimpleName();
      }
    } else if (type instanceof ParameterizedType parameterizedType) {
      StringBuilder infoBuilder = new StringBuilder();

      // append the info about the raw type
      String rawPretty = toPrettyString(parameterizedType.getRawType());
      infoBuilder.append(rawPretty);

      // append the type arguments
      Type[] typeArguments = parameterizedType.getActualTypeArguments();
      if (typeArguments.length > 0) {
        StringJoiner argumentJoiner = new StringJoiner(", ", "<", ">");
        for (Type typeArgument : typeArguments) {
          String argumentPretty = toPrettyString(typeArgument);
          argumentJoiner.add(argumentPretty);
        }
        infoBuilder.append(argumentJoiner);
      }
      return infoBuilder.toString();
    } else if (type instanceof WildcardType wildcardType) {
      // check the lower bounds of the wildcard type
      Type[] lowerBounds = wildcardType.getLowerBounds();
      if (lowerBounds.length > 0) {
        String prettyBound = toPrettyString(lowerBounds[0]);
        return "? super " + prettyBound;
      }

      // check the upper bounds of the type
      Type[] upperBounds = wildcardType.getUpperBounds();
      if (upperBounds.length == 0 || upperBounds[0] == Object.class) {
        return "?";
      } else {
        String prettyBound = toPrettyString(upperBounds[0]);
        return "? extends " + prettyBound;
      }
    } else if (type instanceof GenericArrayType genericArrayType) {
      // get the info about the component type
      String prettyComponentType = toPrettyString(genericArrayType.getGenericComponentType());
      return prettyComponentType + "[]";
    } else if (type instanceof TypeVariable<?> typeVariable) {
      // get the raw type of the bounds
      Type[] bounds = typeVariable.getBounds();
      String prettyBound = toPrettyString(bounds.length == 0 ? Object.class : bounds[0]);

      // append the name of the variable as well
      return prettyBound + " " + typeVariable.getName();
    } else {
      // unknown type, just return the toString value
      return type.toString();
    }
  }
}
