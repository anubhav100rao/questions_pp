move:
	mv *.class ./class_files

push:
	git add .
	git commit -m "updated"
	git push origin master --force
	echo "Updated the local with global successfully..."