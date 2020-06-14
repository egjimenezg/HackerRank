defmodule DigitSum do

  def get_sum(0, sum) do
    sum
  end

  def get_sum(n, sum) do
    sum = sum + rem(n,10)

    n
    |> Integer.floor_div(10)
    |> get_sum(sum)
  end

  def super_digit(digit) when digit < 10, do: digit

  def super_digit(digit) when digit >= 10 do
    get_sum(digit, 0) 
    |> super_digit
  end

  def get_input_super_digit do
    [digit, k] = IO.gets("")
                 |> String.replace("\n", "")
                 |> String.split()
                 |> Enum.map(fn(input) -> 
                    {n,_} = Integer.parse(input)
                    n
                 end)

    digit_sum = digit
                |> get_sum(0)

    digit_sum*k
    |> super_digit()
  end

end

DigitSum.get_input_super_digit
|> IO.inspect
