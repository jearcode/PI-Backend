# Luxe Vision Backend

Este es el repositorio backend del proyecto Luxe Vision. Proporciona endpoints para la gestión de estudios de fotografía, incluyendo detalles como ubicación, fotógrafos y especialidades. La aplicación está construida en Java con Spring Boot.

## Tabla de Contenidos
- [Documentación de API](#documentación-de-api)
- [Endpoints](#endpoints)
---

##Documentación de API
La API cuenta con varios endpoints, detallados a continuación, que permiten la gestión de estudios de fotografía.

## Endpoints

**1. Obtener Estudios Aleatorios**

URL: /studios/random

Método: GET

Descripción: Devuelve una lista de 10 estudios de fotografía seleccionados aleatoriamente.

Respuesta Exitosa (200 OK): Devuelve una lista de estudios de fotografía.

Ejemplo de Solicitud
~~~
GET http://localhost:8080/studios/random
~~~

Respuesta
Código 200 OK:

~~~
[
  {
    "id": 1,
    "studioName": "Luxe Wedding Studio",
    "email": "info@luxewedding.com",
    "phone": "123-456-7890",
    "description": "Specializing in wedding photography.",
    "signup": "2024-10-29T23:38:06.778813",
    "yearsOfExperience": 5,
    "profileImage": "https://fake-s3-bucket.s3.amazonaws.com/profile1.jpg",
    "location": {
        "city": "New York",
        "state": "NY",
        "country": "USA",
        "address": "123 Main St, New York, NY 10001"
    },
    "photographers": [
        {"firstName": "Alice", "lastName": "Smith"}
    ],
    "studioSpecialties": [
        {"specialty": {"specialtyName": "Wedding Photography"}}
    ],
    "portfolioPhotos": [
        {"image": "https://fake-s3-bucket.s3.amazonaws.com/Fake.ico"}
    ]
  }
]
~~~


**2. Crear un Estudio**

URL: /studios

Método: POST

Descripción: Crea un nuevo estudio con información de perfil, fotógrafos y fotos de portafolio.

Parámetros:
~~~
@RequestPart("studio"): JSON del objeto Studio con datos como nombre, email, experiencia, etc.
@RequestPart("profileImage"): Archivo de imagen para el perfil del estudio.
@RequestPart("portfolioImages"): Lista de imágenes para el portafolio del estudio.
~~~

Respuesta Exitosa (201 Created): Devuelve el objeto Studio creado.

Ejemplos de Uso en Postman

Crear un Estudio

Configura una nueva solicitud en Postman:

Método: POST

URL: http://localhost:8080/studios

En el apartado de Body, selecciona form-data y agrega los siguientes campos:

studio: JSON con los datos del estudio. Ejemplo:

~~~
{
  "studioName": "New Studio",
  "email": "newstudio@example.com",
  "phone": "123-456-7890",
  "description": "A description of the new studio",
  "signup": "2024-10-29T23:38:06.778813",
  "yearsOfExperience": 4,
  "location": {
      "city": "San Francisco",
      "state": "CA",
      "country": "USA",
      "address": "789 Willow St, San Francisco, CA 94102"
  },
  "photographers": [
      {"firstName": "John", "lastName": "Doe"},
      {"firstName": "Jane", "lastName": "Smith"}
  ],
  "studioSpecialties": [
      {"specialty": {"id": 1}},
      {"specialty": {"id": 2}}
  ]
}
~~~

Respuesta Exitosa (201 Created):
~~~
{
  "id": 4,
  "studioName": "New Studio",
  "email": "newstudio@example.com",
  "phone": "123-456-7890",
  "description": "A description of the new studio",
  "signup": "2024-10-29T23:38:06.778813",
  "yearsOfExperience": 4,
  "profileImage": "https://fake-s3-bucket.s3.amazonaws.com/profileNew.jpg",
  "location": {
      "city": "San Francisco",
      "state": "CA",
      "country": "USA",
      "address": "789 Willow St, San Francisco, CA 94102"
  },
  "photographers": [
      {"firstName": "John", "lastName": "Doe"},
      {"firstName": "Jane", "lastName": "Smith"}
  ],
  "studioSpecialties": [
      {"specialty": {"id": 1}},
      {"specialty": {"id": 2}}
  ],
  "portfolioPhotos": [
      {"image": "https://fake-s3-bucket.s3.amazonaws.com/photo1.jpg"},
      {"image": "https://fake-s3-bucket.s3.amazonaws.com/photo2.jpg"}
  ]
}
~~~





