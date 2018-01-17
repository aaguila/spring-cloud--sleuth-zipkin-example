import org.springframework.cloud.contract.spec.Contract

    Contract.make {
        request {
            method 'GET'
            url value(consumer(regex('/inventory/[0-9]+')))
            headers {
                contentType(applicationJson())
            }
        }
        response {
            status 200
            body([  item: [
                            [
                                 id: 123456789,
                                 name: 'Explore It!',
                                 stock: 1,
                                 price: 20.00
                            ]
                    ]
            ])
            headers {
                contentType(applicationJson())
            }
        }

}
