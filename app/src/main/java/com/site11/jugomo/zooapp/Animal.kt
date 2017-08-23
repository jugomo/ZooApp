package com.site11.jugomo.zooapp

/**
 * Created by julio on 23/08/17.
 */
class Animal {
    var name: String? = null
    var description: String? = null
    var image: Int? = null
    var isKiller: Boolean = false

    constructor(name: String, description: String, image: Int, isKiller: Boolean) {
        this.name = name
        this.description = description
        this.image = image
        this.isKiller = isKiller
    }

}
