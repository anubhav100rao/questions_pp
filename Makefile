push:
	mv *.class ./class_files
	git add .
	git commit -m "updated"
	git push origin master
	echo "Updated the local with global successfully..."