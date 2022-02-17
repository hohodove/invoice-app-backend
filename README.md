# invoice-app

##### 起動
```
./gradlew run
```

##### デフォルトURL
```
http://localhost:8081/
```

##### 環境変数でポート指定可能
```
export PORT=8085
```

##### オートリロード

```
./gradlew -t build
```

##### Dockerイメージのビルド(初期構築時のみ)
```
cd ~/develop/invoice-app-backend
docker-compose build
docker images
```

##### コンテナ起動、確認
```
docker-compose up -d
docker ps
```

##### コンテナ停止
```
docker-compose stop
```

##### PostgreSQL接続
```
docker exec -it postgresql /bin/bash
psql -U admin -d test
--TABLE一覧
\dt
select * from invoices;
```
