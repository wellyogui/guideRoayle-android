package com.example.well.clashroyaleguide.service.sync.contracts

import com.example.well.clashroyaleguide.service.model.Arena

/**
 * Created by wellingtonyogui on 21/02/2018.
 */

interface ArenaListListener : BaseListener {

    fun onArenaListLoad(arenaList: MutableList<Arena>)

}
