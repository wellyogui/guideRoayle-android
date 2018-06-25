package com.example.well.clashroyaleguide.Service.sync.contracts

import com.example.well.clashroyaleguide.Service.model.Arena

/**
 * Created by wellingtonyogui on 21/02/2018.
 */

interface ArenaListListener : BaseListener {

    fun onArenaListLoad(arenaList: MutableList<Arena>)

}
