package com.ejektaflex.pewter.ext

import net.minecraft.nbt.NBTTagCompound
import kotlin.reflect.KClass
import kotlin.reflect.KFunction2

object NBTMapping {
    val setMap = mapOf(
            Float::class to NBTTagCompound::setFloat,
            Int::class to NBTTagCompound::setInteger,
            Long::class to NBTTagCompound::setLong
    )

    val getMap = mapOf(
            Float::class to NBTTagCompound::getFloat,
            Int::class to NBTTagCompound::getInteger,
            Long::class to NBTTagCompound::getLong
    )
}

enum class NBTMap(
        val clazz: KClass<*>,
        val getter: KFunction2<NBTTagCompound, @ParameterName(name = "key") String, Any>,
        val setter: NBTTagCompound.(key: String, it: Any) -> Unit
) {
    FLOAT(Float::class, NBTTagCompound::getFloat, { key, it -> setFloat(key, it as Float) } ),
    INT(Int::class, NBTTagCompound::getInteger, { key, it -> setInteger(key, it as Int) } ),
    LONG(Long::class, NBTTagCompound::getLong, { key, it -> setLong(key, it as Long) })
}

inline operator fun <reified T : Any> NBTTagCompound.get(key: String): T {
    val type = NBTMap.values().first { it.clazz == T::class }
    return type.getter(this, key) as T
}

inline operator fun <reified T : Any> NBTTagCompound.set(key: String, value: T) {
    val type = NBTMap.values().first { it.clazz == T::class }
    type.setter(this, key, value)
}

/*
fun <T> NBTTagCompound.safe(key: String): T {
    if (!hasKey(key)) {

    }
}
*/

