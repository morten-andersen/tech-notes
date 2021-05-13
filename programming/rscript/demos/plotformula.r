#!/usr/bin/Rscript

# small sample that generate a PDF plot of a formula

# 'plot' documentation
#   https://www.rdocumentation.org/packages/graphics/versions/3.6.2/topics/plot

x <- 1:100                  # Create vector.
y <- x^2                    # Create vector by formula.

png("out/plotformula.png")  # Specify the png output file name
plot(x, y, type = "l")      # Plot the values as a line = l

pdf("out/plotformula.pdf")  # Specify the pdf output file name
plot(x, y, type = "l")      # Plot the values as a line = l
