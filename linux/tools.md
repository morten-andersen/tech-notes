### Tools

#### Base64 encoding / decoding

Encoding / decoding files

```bash
base64 inputfile.txt > encodedfile # encode a file
base64 -d encodedfile > outputfile.txt # decode a file
```

Encoding / decoding strings

```bash
echo 'some-string' | base64 # encode a string
echo 'base64-string' | base64 -d # decode a string
```

#### Substrings in Bash

[Extracting a Substring in Bash](https://www.baeldung.com/linux/bash-substring) describes both index-based and pattern-based substring extractions.
