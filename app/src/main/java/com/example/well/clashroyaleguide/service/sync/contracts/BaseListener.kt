package com.example.well.clashroyaleguide.service.sync.contracts

/**
 * Created by wellingtonyogui on 21/02/2018.
 */

interface BaseListener {

    /**
     * Api Started Loading      * Time to show loading screen
     */
    fun onRequestStarted()

    /**
     * Api Finished Loading      * Time to dismiss loading screen
     */
    fun onRequestFinished()

    /**
     * Error occured      *      * @param error - Exception
     */
    fun onError(error: Throwable)

}
