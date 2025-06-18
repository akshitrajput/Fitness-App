package com.example.fitnessapp.main_pages.meal_pages

data class Nutrients(
    val calories: Float,
    val protein: Float,
    val fat: Float,
    val carbs: Float
)

data class DrinkItem(
    val id: String,
    val name: String,
    val caloriePer100ml: Float,
    val proteinPer100ml: Float,
    val fatPer100ml: Float,
    val carbsPer100ml: Float,
    val quantity: Float
) {
    fun calculateMacros(quantityInMl: Float): Nutrients {
        val factor = quantityInMl / 100f
        return Nutrients(
            calories = caloriePer100ml * factor,
            protein = proteinPer100ml * factor,
            fat = fatPer100ml * factor,
            carbs = carbsPer100ml * factor
        )
    }
}

object DrinkRepository {
    val drinkList = listOf(
        // Fruit Juices
        DrinkItem("1", "Orange Juice", 45f, 0.7f, 0.2f, 10.4f, 250f),
        DrinkItem("2", "Apple Juice", 46f, 0.1f, 0f, 11.3f, 250f),
        DrinkItem("3", "Grape Juice", 60f, 0.1f, 0f, 15.5f, 250f),
        DrinkItem("4", "Pineapple Juice", 50f, 0.5f, 0.1f, 13.7f, 250f),
        DrinkItem("5", "Cranberry Juice", 46f, 0.1f, 0f, 12f, 250f),
        DrinkItem("6", "Mango Juice", 60f, 0.5f, 0.1f, 14.9f, 250f),
        DrinkItem("7", "Pomegranate Juice", 54f, 0.2f, 0.1f, 13.7f, 250f),
        DrinkItem("8", "Watermelon Juice", 30f, 0.4f, 0.2f, 7.6f, 250f),
        DrinkItem("9", "Lemonade", 40f, 0f, 0f, 10f, 250f),
        DrinkItem("10", "Limeade", 38f, 0f, 0f, 9.6f, 250f),

        // Traditional & Regional
        DrinkItem("11", "Papaya Juice", 39f, 0.4f, 0.1f, 9.8f, 250f),
        DrinkItem("12", "Guava Juice", 68f, 1f, 0.5f, 14f, 250f),
        DrinkItem("13", "Lychee Juice", 66f, 0.8f, 0.1f, 16.5f, 250f),
        DrinkItem("14", "Peach Juice", 39f, 0.5f, 0.1f, 9.5f, 250f),
        DrinkItem("15", "Strawberry Juice", 33f, 0.7f, 0.3f, 8.1f, 250f),
        DrinkItem("16", "Melon Juice", 30f, 0.6f, 0.1f, 7.3f, 250f),
        DrinkItem("17", "Kiwi Juice", 41f, 0.7f, 0.2f, 10.5f, 250f),
        DrinkItem("18", "Passionfruit Juice", 97f, 2.2f, 0.7f, 23.4f, 250f),
        DrinkItem("19", "Tamarind Juice", 45f, 1f, 0.1f, 12.5f, 250f),
        DrinkItem("20", "Aam Panna", 33f, 0.4f, 0f, 8.5f, 250f),

        DrinkItem("21", "Jaljeera", 25f, 0.3f, 0f, 6f, 250f),
        DrinkItem("22", "Nimbu Pani", 30f, 0f, 0f, 7.5f, 250f),
        DrinkItem("23", "Sattu Drink", 120f, 5f, 2f, 15f, 250f),
        DrinkItem("24", "Kokum Sharbat", 35f, 0.1f, 0f, 8.5f, 250f),
        DrinkItem("25", "Rooh Afza", 120f, 0f, 0f, 30f, 250f),
        DrinkItem("26", "Thandai", 150f, 4f, 7f, 16f, 250f),
        DrinkItem("27", "Kesar Kasturi", 60f, 0.5f, 0.2f, 12f, 250f),
        DrinkItem("28", "Shikanji", 28f, 0f, 0f, 7f, 250f),
        DrinkItem("29", "Nimbu Masala Soda", 35f, 0f, 0f, 8f, 250f),

        // Cold & Carbonated
        DrinkItem("30", "Coca-Cola", 42f, 0f, 0f, 10.6f, 250f),
        DrinkItem("31", "Pepsi", 41f, 0f, 0f, 10.9f, 250f),
        DrinkItem("32", "Sprite", 38f, 0f, 0f, 9.5f, 250f),
        DrinkItem("33", "Fanta", 47f, 0f, 0f, 11.4f, 250f),
        DrinkItem("34", "Ginger Ale", 36f, 0f, 0f, 9f, 250f),
        DrinkItem("35", "Root Beer", 45f, 0f, 0f, 11f, 250f),
        DrinkItem("36", "Tonic Water", 35f, 0f, 0f, 8.9f, 250f),
        DrinkItem("37", "Club Soda", 0f, 0f, 0f, 0f, 250f),
        DrinkItem("38", "Lemon-Lime Soda", 40f, 0f, 0f, 10f, 250f),
        DrinkItem("39", "Cream Soda", 45f, 0f, 0f, 12f, 250f),

        // Mocktails & Sweet Beverages
        DrinkItem("40", "Virgin Mojito", 25f, 0.1f, 0f, 6.5f, 250f),
        DrinkItem("41", "Virgin Piña Colada", 120f, 1f, 4f, 15f, 250f),
        DrinkItem("42", "Shirley Temple", 110f, 0f, 0f, 28f, 250f),
        DrinkItem("43", "Fruit Punch", 70f, 0.5f, 0f, 17f, 250f),
        DrinkItem("44", "Iced Tea", 15f, 0f, 0f, 4f, 250f),
        DrinkItem("45", "Iced Coffee", 40f, 1f, 1.5f, 6f, 250f),
        DrinkItem("46", "Milkshake (Vanilla)", 150f, 5f, 4f, 22f, 250f),
        DrinkItem("47", "Milkshake (Chocolate)", 180f, 5f, 5f, 25f, 250f),
        DrinkItem("48", "Milkshake (Strawberry)", 160f, 5f, 4f, 23f, 250f),
        DrinkItem("49", "Smoothie (Mixed Fruit)", 140f, 2f, 1f, 30f, 250f),
        DrinkItem("50", "Frappuccino", 180f, 2f, 3f, 28f, 250f),
        DrinkItem("51", "Slushie", 90f, 0f, 0f, 22f, 250f),

        // Dairy & Coffee Variants
        DrinkItem("52", "Whole Milk", 61f, 3.2f, 3.3f, 5f, 250f),
        DrinkItem("53", "Skim Milk", 34f, 3.4f, 0.1f, 5f, 250f),
        DrinkItem("54", "Chocolate Milk", 83f, 3.3f, 2.5f, 12f, 250f),
        DrinkItem("55", "Coffee (Black)", 1f, 0.1f, 0f, 0f, 250f),
        DrinkItem("56", "Coffee (With Milk & Sugar)", 60f, 2f, 1.5f, 8f, 250f),
        DrinkItem("57", "Green Tea", 1f, 0f, 0f, 0f, 250f),
        DrinkItem("58", "Herbal Tea", 2f, 0f, 0f, 0.5f, 250f),
        DrinkItem("59", "Chai (Indian Tea)", 45f, 1f, 2f, 6f, 250f),

        // Other Common Drinks
        DrinkItem("60", "Coconut Water", 19f, 0.7f, 0.2f, 4.5f, 250f),
        DrinkItem("61", "Energy Drink", 45f, 0f, 0f, 11f, 250f),
        DrinkItem("62", "Protein Shake", 120f, 20f, 1.5f, 3f, 250f),
        DrinkItem("63", "Soy Milk", 33f, 3.3f, 1.8f, 0.7f, 250f),
        DrinkItem("64", "Almond Milk (Unsweetened)", 13f, 0.5f, 1.1f, 0.3f, 250f),
        DrinkItem("65", "Oat Milk", 43f, 1f, 1.5f, 7f, 250f),
        DrinkItem("66", "Tomato Juice", 17f, 0.8f, 0.2f, 3.9f, 250f),
        DrinkItem("67", "Vegetable Juice", 25f, 1f, 0.1f, 5f, 250f),
        DrinkItem("68", "Hot Chocolate", 90f, 3f, 2.5f, 14f, 250f),
        DrinkItem("69", "Bubble Tea (Milk Tea)", 180f, 3f, 4f, 30f, 250f),
        DrinkItem("70", "Kefir (Fermented Milk Drink)", 60f, 3.3f, 3.2f, 4f, 250f)
    )
}