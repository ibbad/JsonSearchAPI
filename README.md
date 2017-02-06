# JsonSearchAPI
Rest API to search arbitrary string in given JSON
Usage:

# Bad JSON will not be accepted, 400 will be returned.
curl -H "Content-Type: application/json" -d '{jsonpayload: {"businesses": [ { "id": "yelp-tropisueno", "name" : "Tropisueno", "display_phone": "+1-415-908-3801", "image_url": "http://s3-media2.ak.yelpcdn." potato" com/bphoto/7DIHu8a0AHhw-BffrDIxPA/ms.jpg, "description": ""}]}}' -X GET http://localhost:8080/search?key=image_url

# The value of given key is searched and returned as string 
curl -H "Content-Type: application/json" -d '{jsonpayload: {"businesses": [ { "id": "yelp-tropisueno", "name" : "Tropisueno", "display_phone": "+1-415-908-3801", "image_url": "http://s3-media2.ak.yelpcdn.com/bphoto/7DIHu8a0AHhw-BffrDIxPA/ms.jpg", "description": ""}]}}' -X GET http://localhost:8080/search?key=image_url


# Since given key is not available, it will return HTTPStatus.NO_CONTENT in result
curl -H "Content-Type: application/json" -d '{jsonpayload: {"businesses": [ { "id": "yelp-tropisueno", "name" : "Tropisueno", "display_phone": "+1-415-908-3801", "image_url": "http://s3-media2.ak.yelpcdn.com/bphoto/7DIHu8a0AHhw-BffrDIxPA/ms.jpg", "description": ""}]}}' -X GET http://localhost:8080/search?key=image_url1
