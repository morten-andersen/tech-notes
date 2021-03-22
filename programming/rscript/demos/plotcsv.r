#!/usr/bin/Rscript

# small sample that reads data from a CSV file and
# uses 'plot' for creating both a png and a pdf with the data plotted

# 'plot' documentation
#   https://www.rdocumentation.org/packages/graphics/versions/3.6.2/topics/plot

data <- read.csv("datafile.csv", header = TRUE) # Read from csv file

print(data)             # Print the file contents.
print(data$x)           # Print values for column X
print(data[2])          # Print values for column '2'

png("out/plotcsv.png")  # Specify the png output file name
plot(data, type = "l")  # Plot the values as a line = l

pdf("out/plotcsv.pdf")  # Specify the pdf output file name
plot(data, type = "l")  # Plot the values as a line = l
