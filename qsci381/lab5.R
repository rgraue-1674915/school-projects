bottle <- c(484.11, 459.49, 471.38, 512.01, 494.48, 528.63, 493.64, 485.03, 473.88, 501.59, 502.85
            , 538.08, 465.68, 495.03, 475.32, 529.41, 518.13, 464.32, 449.08, 489.27)
mBot <- mean(bottle)
stdBot <- sd(bottle)
varBot <- var(bottle)

t.test(bottle, mu=500, alternative = c("less"))

bottle2 <- c(499.46, 501.42, 503.41, 498.27, 500.61, 502.67, 500.46, 501.83
             , 502.58, 501.89, 502.30, 500.85, 498.45, 501.28, 499.72)

mBot2 <- mean(bottle2)
stdBot2 <- sd(bottle2)
varBot2 <- var(bottle2)

cvBot <- stdBot / mBot *100
cvBot2 <- stdBot2/mBot2 *100

t.test(bottle2, mu=500, alternative = c("greater"))

pre <- c(5,6,5,7,5,4,6,7,8,4)
post <- c(8,6,7,9,8,9,6,7,5,9)

