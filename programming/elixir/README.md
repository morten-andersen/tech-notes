### Elixir

https://elixir-lang.org

Language that runs on top of the Erlang VM.

#### Install on Ubuntu

```bash
# install Erlang
wget https://packages.erlang-solutions.com/erlang-solutions_2.0_all.deb && sudo dpkg -i erlang-solutions_2.0_all.deb
sudo apt update
sudo apt install esl-erlang

# install Elixir
sudo apt install elixir
```

#### Basic Usage

* `elixir -v` - version
* `iex` - REPL
  * `iex -r <file>.ex` - load the file so the functions in it can be used from the REPL
* `elixir <file>.exs` - execute script in file

#### File Types

* `*.ex` - files that should be compiled
* `*.exs` - script files. Can be executed with `elixir`.

> Elixir treats both files exactly the same way, the only difference is in intention. .ex files are meant to be compiled while .exs files are used for scripting. When executed, both extensions compile and load their modules into memory, although only .ex files write their bytecode to disk in the format of .beam files.
[[Scripted mode](https://elixir-lang.org/getting-started/modules-and-functions.html#scripted-mode)]

##### [Compilation](https://elixir-lang.org/getting-started/modules-and-functions.html#compilation)

* `elixirc <file>.ex`

#### Stdout and Stdin

* `IO.puts "hello\nworld"` - prints the double line string to stdout
* `System.argv |> IO.puts` - prints all arguments (with no spacing)

#### [Basic Types](https://elixir-lang.org/getting-started/basic-types.html)

**[Strings](https://elixir-lang.org/getting-started/basic-types.html#strings)**

* `"string"` - strings are in double quotes
  * `"string #{var}"` - string interpolation
* `'char list'` - a char list
* `"foo" <> "bar"` - string concatenation

[[Elixir - Binaries, strings, and charlists](https://elixir-lang.org/getting-started/binaries-strings-and-char-lists.html)]

#### [Regular Expressions](https://elixir-lang.org/getting-started/sigils.html#regular-expressions)

* `~s/pattern/` - a regular expression

Everything that starts with `~` are *sigils*

> sigils are one of the mechanisms provided by the language for working with textual representations. Sigils start with the tilde (~) character which is followed by a letter (which identifies the sigil) and then a delimiter; optionally, modifiers can be added after the final delimiter.
[[Sigils](https://elixir-lang.org/getting-started/sigils.html)]

#### [Modules and Functions](https://elixir-lang.org/getting-started/modules-and-functions.html)

##### `defModule` macro

Use the `defModule` macro to define a *module* grouping multiple functions - demo in [demos/Math.exs](./demos/Math.exs)

```elixir
# Call with elixir demos/Math.exs 1 2
defmodule Math do
  def sum(a, b) do
    a + b
  end

  def sum([a, b]) do
    sum a, b
  end
end

System.argv
|> Enum.map(&String.to_integer/1)
|> Math.sum
|> IO.puts
```

##### `def` and `defp` macros

* `def` - for public functions
* `defp` - for private functions, only callable inside the module
