## My Voucher store

### Tests

![Java CI](https://github.com/Michal41/voucherShop/workflows/Java%20CI/badge.svg)

in order to perform tests on your own, feel free to execute

```bash
mvn test
```


### test via CURL

#### CRUD
##### Create
add Client
```bash
curl -X POST http://localhost:9999/api/clients -H 'content-type: application/json' -d '{ "firstname": "Michal", "lastname":"Kanarek", "address":{"street": "x", "zip": "123-22", "city": "krakow"} }'
```
##### Read
get single Client
```bash
curl http://localhost:9999/api/clients/1
```

get list

```bash
curl http://localhost:9999/api/clients
```

##### Update
```bash
curl -X POST http://localhost:9999/api/clients/1 -H 'content-type: application/json' -d '{ "firstname": "Michal", "lastname":"Kanarek", "address":{"street/1": "x", "zip": "123-22", "city": "Vienna"} }'
```

##### Delete
```bash
curl -X DELETE http://localhost:9999/api/clients/2
```




