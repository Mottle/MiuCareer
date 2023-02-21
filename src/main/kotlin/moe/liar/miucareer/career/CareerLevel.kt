package moe.liar.miucareer.career



data class CareerLevel(val level: UInt = 0u,
                        val experience: UInt = 0u,
                        val experienceLimit: UInt = 1u) {
    fun updateExp(exp: UInt = 1u, calExpLimit: (UInt) -> UInt = ::calExperienceLimit) : CareerLevel {
        val nextLevelExpLimit = calExpLimit(level + 1u)
        if (exp + experience >= experienceLimit)
            return copy(level + 1u, experience + exp - experienceLimit, nextLevelExpLimit).updateExp(0u, calExpLimit)
        return copy(experience = experience + exp)
    }
}

