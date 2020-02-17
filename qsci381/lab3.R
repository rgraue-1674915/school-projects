tempulse <- TempPulse
tempulse <- read.csv("TempPulse.csv", head = TRUE, sep=",")
attach(tempulse)
head(tempulse)



tMean <- mean(tempulse$Temp)
tVar <- var(tempulse$Temp)
tSTD <- sd(tempulse$Temp)

pMean <- mean(tempulse$Pulse)
pVar <- var(tempulse$Pulse)
pSTD <- sd(tempulse$Pulse)

get.cv(100,50)

get.cv <- function (std , mean){
  cv <- (std / mean) * 100;
  return(cv)
}

zScore <- function(x, xbar, std){
  return((x-xbar)/std)
}

par(mfrow=c(2,2))

pulse <- tempulse$Pulse
temp <- tempulse$Temp
hist(pulse, col = "red", main = "Histogram of heart pulse", xlab = "Beats per minute", ylab = "frequency")
hist(temp, col = "blue", main = "Histogram of body Temperature", xlab = "Body temp (F)", ylab = "Frequency")

qqnorm(pulse, main = "Q-Q plot of Pulse", col = "red")
qqline(pulse, col = "red")

qqnorm(temp, main = "Q-Q plot of Temp", col = "blue")
qqline(temp, col = "blue")
