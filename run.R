path = "d:/devel/FI_JAVA/PA164/"
setwd(path)
out = system(
	paste("java -jar target/text-graph-1.0-SNAPSHOT.jar", path, "100000 10 7"),
	intern = TRUE,
	wait = TRUE
	)


