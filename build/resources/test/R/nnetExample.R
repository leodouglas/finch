require(caret)

predictionNN <- predict(fitNnet.finalModel,pattern)
predictionGLM <- predict(fitGlm.finalModel,pattern)
prediction <- mean(c(predictionNN,predictionGLM))

score <- prediction

decision <- "none"