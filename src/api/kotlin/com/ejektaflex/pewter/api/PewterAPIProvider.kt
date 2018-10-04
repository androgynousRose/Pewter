package com.ejektaflex.pewter.api

open class PewterAPIProvider : IPewterAPI by api {
    companion object {
        protected var api: IPewterAPI = object : IPewterAPI {}
        fun changeAPI(newAPI: IPewterAPI) {
            api = newAPI
            api.log("Using Pewter API: ${newAPI::class.simpleName}")
        }
    }
}