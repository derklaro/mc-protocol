# MC Protocol

This repository contains a generator which can automatically pull the latest mc version (release or snapshot) from the
mc download servers, deobfuscate it, and generate a markdown file with all connection state, packet flows and packet
fields.

The specification in a pre-generated form for the current snapshot (updated each day at 12am UTC) is available via:

* [Website](https://protocol.derklaro.dev/)
* [GitHub](https://github.com/derklaro/mc-protocol/blob/gh-pages/readme.md)

All versions that were ever generated are [tagged](https://github.com/derklaro/mc-protocol/tags).

### Output format

The final markdown file has 4 fields for each field of a packet:

* `Index`: The index of the field in the packet class.
* `Type Index`: The index of the field within the fields that have the same type. This information is (for example)
  required when working with ProtocolLib which reads fields based on the relative index of the fields' type.
* `Name`: The name of the field. This should be an indicator what the field is supposed to represent.
* `Raw Type`: The raw type of the field, without any generic information.
* `Full Type`: The full generic type of the field, this can be useful to (for example) understand what type of elements
  are in a collection.

### Running the generator

To run the generator java version 17 (or newer) is required. You need to build the protocol generator from source using
gradle:

* Windows: `gradlew.bat build`
* Unix: `./gradlew build`

The final executable jar is located at: `build/libs/protocol-generator.jar`. When running you can specify the following
options:

| Name                      | Description                                                                                                                                                                    | Default Value | Required |
|---------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------|----------|
| `--version-type` or `-vt` | Sets the version type to process (one of: `RELEASE`, `SNAPSHOT`, `LATEST`). This tries to generate the specification for the latest available version of the type.             | `LATEST`      | no       |
| `--output-file` or `-of`  | Sets the file name of the output file to generate. The file contain the generated markdown for the protocol version. Note that parent directories need to be created manually. | `readme.md`   | no       |
| `--version-file` or `-vf` | Sets the file name to which the processed version id should be dumped. If this option is not specified, the version will not be written to any file.                           | no default    | no       |

### License

This generator is released under the terms of the MIT license. See [license.txt](../license.txt)
or https://opensource.org/licenses/MIT.
