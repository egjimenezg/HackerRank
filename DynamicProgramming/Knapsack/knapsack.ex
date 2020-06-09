defmodule Knapsack do

  def read_cases_number() do
    {n, ""} = IO.gets("")
              |> String.replace("\n","")
              |> Integer.parse()
    n
  end
  
  def read_array() do
    IO.gets("")
    |> String.replace("\n","")
    |> String.split()
    |> Enum.map(fn(array_item) -> 
      {number, _} = Integer.parse(array_item)
      number
    end)
  end

  def get_sum([], sum, _) do
    sum
  end

  def get_sum(_, sum, 0) do
    sum 
  end

  def get_sum(list, sum, target) do
    [current_item|t] = list

    case current_item do
      current_item when current_item > target ->
        get_sum(t, sum, target)
      _ -> get_sum(list, sum+current_item, target-current_item)
           |> max(get_sum(t, sum, target))
    end 
  end

end

1..Knapsack.read_cases_number()
|> Enum.each(fn(_) -> 
  [_, target] = Knapsack.read_array()

  Knapsack.read_array()
  |> Knapsack.get_sum(0, target)
  |> IO.puts
end)

