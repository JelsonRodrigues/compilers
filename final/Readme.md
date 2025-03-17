# Making a transpiler

# Building
There is a Containerfile to build the application.

Just use your favorite container application

`podman build -t final .`

To run use

`podman run final -v file_to_compile:/input.txt`

Ex.:

`podman run final -v ./test/test1.txt:input.txt`


The output is the Rust code from the Lugosi language. You can then use the Rust compiler to compile into a binary file.

`podman run final -v ./test/test1.txt:input.txt | rustc -`