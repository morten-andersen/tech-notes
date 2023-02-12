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
