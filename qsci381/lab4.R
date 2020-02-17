attach(trees)

par(mfrow=c(1,3))
hist(trees$Girth, main = "Histogram of tree Girth", col="slateblue4", xlab = "girth (in.)")
hist(trees$Height, main = "Histogram of tree height", col = "seagreen2", xlab = "height (ft.)")
hist(trees$Volume, main = "Histogram of tree volume", col = "mistyrose", xlab = "volume (cubic ft.)")

par(mfrow=c(1,3))
qqnorm(trees$Girth, col="slateblue4", main = "Q-Q plot of tree girth")
qqline(trees$Girth, col = "slateblue4")
qqnorm(trees$Height, main = "Q-Q plot of tree height", col = "seagreen2")
qqline(trees$Height, col = "seagreen2")
qqnorm(trees$Volume, main = "Q-Q plot of tree volume", col = "red")
qqline(trees$Volume, col = "red")


