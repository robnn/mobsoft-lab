First create the basic-docker-img with a command:
```
$ cd basic-docker-img
$ sudo docker build -t basic_image
```

Then build the file manager docker image

```
$ cd ..
$ sudo docker build -t file_manager
```

Then run the *file_manager* docker image:

```
$ sudo docker run file_manager
```
