import org.springframework.cloud.contract.spec.Contract

    Contract.make {
        request {
            method 'POST'
            url  '/purchase'
            headers {
                contentType(applicationJson())
            }
            body(
                    account: $(consumer(regex('[0-9]+'))),
                    item: $(consumer(regex('[0-9]+')))
            )
        }
        response {
            status 200
            body([  order: [
                                id: '123456789',
                                itemName: 'Explore It!',
                                accountName: 'aaguila',
                                status: 'PURCHASED'
                            ]
            ])
            headers {
                contentType(applicationJson())
            }
        }

}
