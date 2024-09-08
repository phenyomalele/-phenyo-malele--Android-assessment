package com.glucode.about_you

import com.glucode.about_you.engineers.models.Engineer
import com.glucode.about_you.engineers.models.QuickStats
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EngineerSortingTest {
    private lateinit var engineers: List<Engineer>

    @Before
    fun setUp() {
        engineers = mutableListOf(
            Engineer(
                name = "Phenyo",
                role = "Android Developer",
                defaultImageName = "phenyo.jpeg",
                quickStats = QuickStats(coffees = 10, years = 5, bugs = 20),
                questions = listOf()
            ),
            Engineer(
                name = "Khanya",
                role = "iOS Developer",
                defaultImageName = "khanya.jpeg",
                quickStats = QuickStats(coffees = 5, years = 2, bugs = 10),
                questions = listOf()
            ),
            Engineer(
                name = "Sarah",
                role = "Java Developer",
                defaultImageName = "sarah.jpeg",
                quickStats = QuickStats(coffees = 15, years = 10, bugs = 5),
                questions = listOf()
            )
        )
    }

    @Test
    fun sortInAscendingByCoffeeShouldSortEngineersByCoffees() {
        engineers = engineers.sortedBy { it.quickStats.coffees }.toMutableList()

        assertEquals("Khanya", engineers[0].name)
        assertEquals("Phenyo", engineers[1].name)
        assertEquals("Sarah", engineers[2].name)
    }

    @Test
    fun sortInAscendingByYearsShouldSortEngineersByYears() {
        engineers = engineers.sortedBy { it.quickStats.years }.toMutableList()

        assertEquals("Khanya", engineers[0].name)
        assertEquals("Phenyo", engineers[1].name)
        assertEquals("Sarah", engineers[2].name)
    }

    @Test
    fun sortInAscendingByBugsShouldSortEngineersByBugs() {
        engineers = engineers.sortedBy { it.quickStats.bugs }.toMutableList()

        assertEquals("Sarah", engineers[0].name)
        assertEquals("Khanya", engineers[1].name)
        assertEquals("Phenyo", engineers[2].name)
    }
}