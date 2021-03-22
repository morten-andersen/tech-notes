#!/usr/bin/Rscript

# R (http://www.r-project.org/) script
# from https://en.wikipedia.org/wiki/R_(programming_language)#Basic_syntax

x <- 1:6              # Create vector.
y <- x^2              # Create vector by formula.

print(y)              # Print the vector’s contents.

mean(y)               # Arithmetic mean of vector.

var(y)                # Sample variance of vector.

model <- lm(y ~ x)    # Linear regression model y = A + B * x.

print(model)          # Print the model’s results.

summary(model)        # Display an in-depth summary of the model.

pdf("out/model.pdf")  # Specify the pdf output file name
par(mfrow = c(2, 2))  # Create a 2 by 2 layout for figures.
plot(model)           # Plot diagnostic plots of the model.
