package com.ejektaflex.pewter.api

/**
 * [PewterAPIProvider] is a wrapper around an empty instance of the Pewter API.
 * At the time of mod construction, it gets replaced by Pewter's internal API
 * implementation.
 */
open class PewterAPIProvider : IPewterAPI by api {
    companion object {
        protected var api: IPewterAPI = object : IPewterAPI {}
        /**
         * Used to change the PewterAPI implementation.
         * @param newAPI The new API implementation to use.
         */
        fun changeAPI(newAPI: IPewterAPI) {
            api = newAPI
            api.log("Using Pewter API: ${newAPI::class.simpleName}")
        }
    }
}