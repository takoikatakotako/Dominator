# Dominator

Simple `zlib` compressed file decomposer.


## Why is it called Dominator?

[PSYCHO-PASS Dominator](https://dic.pixiv.net/a/%E6%90%BA%E5%B8%AF%E5%9E%8B%E5%BF%83%E7%90%86%E8%A8%BA%E6%96%AD%E9%8E%AE%E5%9C%A7%E5%9F%B7%E8%A1%8C%E3%82%B7%E3%82%B9%E3%83%86%E3%83%A0)


## Usage

Move to the directory containing the file you want to compress or decomposess.

### Compress

```
docker run --rm -v $PWD:/output kabigon/dominator compress sample.json sample.zlib
```

### Decompress

```
docker run --rm -v $PWD:/output kabigon/dominator decompress sample.zlib sample.json 
```


## Build

```
docker build -t kabigon/dominator:latest .
```



## Push

```
docker push kabigon/dominator:latest
```