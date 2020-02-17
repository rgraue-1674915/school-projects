pacWhale <- c(420, 729, 442, 529, 484, 720, 453, 1002, 561, 980, 806, 263, 897,
              652, 575, 346, 794, 553, 410, 417, 830, 1050, 1196, 687, 629, 1125,
              496, 998, 62, 735, 628, 1082, 732, 474, 111, 716, 567, 646, 286, 531,
              550, 1346, 1401, 949, 644, 787, 929, 756, 763, 1035, 631, 1235, 395,
              302, 804, 388, 574, 568, 491, 1389, 1125)
atlWhale <- c(619, 285, 415, 756, 288, 435, 473, 487, 512, 552, 795, 544, 472, 731,
              290, 772, 674, 387, 670, 271, 648, 323, 344, 399, 817, 616, 396, 597,
              594, 363, 332, 457, 456, 125, 566, 884, 560, 442, 722, 374, 485, 370,
              343, 658, 425, 424, 489, 480, 431, 602, 576, 348, 331, 432, 538)

hist(pacWhale, xlab = "Dive Depth", ylab = "Frequency of Dive Depth", main = "Histogram of Pacific Sperm Whale Dive Depth", col = "tomato")
hist(atlWhale, xlab = "Dive Depth", ylab = "Frequency of Dive Depth", main = "Histogram of Atlantic Sperm Whale Dive Depth", col = "skyblue" )

hist(pacWhale, xlab = "Dive Depth", ylab = "Frequency of Dive Depth", main = "Histogram of Pacific Sperm Whale Dive Depth", col = "mediumpurple", xlim = c(0,1600), ylim = c(0,15), breaks = 10)
hist(atlWhale, xlab = "Dive Depth", ylab = "Frequency of Dive Depth", main = "Histogram of Atlantic Sperm Whale Dive Depth", col = "orchid3", xlim = c(0,1600), ylim = c(0,15), breaks = 10)

mean(pacWhale)
min(pacWhale)
max(pacWhale)
var(pacWhale)
sd(pacWhale)

mean(atlWhale)
min(atlWhale)
max(atlWhale)
var(atlWhale)
sd(atlWhale)

pacR <- max(pacWhale) - min(pacWhale)
pacR

pacA <- max(atlWhale) - min(atlWhale)
pacA

sd(pacWhale) / mean(pacWhale) * 100
sd(atlWhale) / mean(atlWhale) * 100

mean(pacWhale) + (2 * sd(pacWhale))
mean(pacWhale) - (2 * sd(pacWhale))

mean(atlWhale) + (2 * sd(atlWhale))
mean(atlWhale) - (2 * sd(atlWhale))

quantile(PacWhale)
quantile(atlWhale)

IQR(pacWhale)
IQR(atlWhale)
