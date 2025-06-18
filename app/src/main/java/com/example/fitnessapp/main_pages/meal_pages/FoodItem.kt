package com.example.fitnessapp.main_pages.meal_pages


data class FoodItem(
    val id: String,
    val name: String,
    val caloriePer100g: Float,
    val proteinPer100g: Float,
    val fatPer100g: Float,
    val carbsPer100g: Float,
    val quantity: Float
) {
    fun calculateMacros(quantityInGrams: Float): Nutrients {
        val factor = quantityInGrams / 100f
        return Nutrients(
            calories = caloriePer100g * factor,
            protein = proteinPer100g * factor,
            fat = fatPer100g * factor,
            carbs = carbsPer100g * factor
        )
    }
}

object FoodRepository {
    val foodList = listOf(
        // Grains & Cereals
        FoodItem("1", "White Rice (Boiled)", 130f, 2.6f, 0.3f, 28.7f, 100f),
        FoodItem("2", "Brown Rice (Boiled)", 111f, 2.6f, 0.9f, 23.0f, 100f),
        FoodItem("3", "Quinoa (Cooked)", 120f, 4.4f, 1.9f, 21.3f, 100f),
        FoodItem("4", "Oats (Rolled)", 389f, 16.9f, 6.9f, 66.3f, 100f),
        FoodItem("5", "Whole Wheat Bread", 247f, 8.0f, 3.4f, 41.0f, 100f),
        FoodItem("6", "Pasta (Boiled)", 131f, 5.0f, 1.1f, 25.0f, 100f),

        // Legumes & Pulses
        FoodItem("7", "Lentils (Boiled)", 116f, 9.0f, 0.4f, 20.1f, 100f),
        FoodItem("8", "Chickpeas (Boiled)", 164f, 8.9f, 2.6f, 27.4f, 100f),
        FoodItem("9", "Kidney Beans (Boiled)", 127f, 8.7f, 0.5f, 22.8f, 100f),
        FoodItem("10", "Black Beans (Boiled)", 132f, 8.9f, 0.9f, 23.7f, 100f),
        FoodItem("11", "Soybeans (Boiled)", 173f, 16.6f, 9.0f, 9.9f, 100f),

        // Dairy & Alternatives
        FoodItem("12", "Whole Milk", 61f, 3.3f, 3.3f, 4.8f, 100f),
        FoodItem("13", "Skim Milk", 34f, 3.4f, 0.1f, 4.9f, 100f),
        FoodItem("14", "Paneer (Cottage Cheese)", 265f, 18.0f, 20.0f, 1.2f, 100f),
        FoodItem("15", "Greek Yogurt (Plain)", 59f, 10.0f, 0.4f, 3.6f, 100f),
        FoodItem("16", "Almond Milk (Unsweetened)", 13f, 0.5f, 1.1f, 0.3f, 100f),
        FoodItem("17", "Soy Milk", 33f, 3.3f, 1.8f, 0.7f, 100f),

        // Meats & Poultry
        FoodItem("18", "Chicken Breast (Cooked)", 165f, 31.0f, 3.6f, 0.0f, 100f),
        FoodItem("19", "Turkey Breast (Cooked)", 135f, 29.0f, 1.0f, 0.0f, 100f),
        FoodItem("20", "Salmon (Cooked)", 206f, 22.0f, 12.0f, 0.0f, 100f),
        FoodItem("21", "Egg (Whole, Boiled)", 155f, 13.0f, 11.0f, 1.1f, 100f),
        FoodItem("22", "Beef (Lean, Cooked)", 250f, 26.0f, 15.0f, 0.0f, 100f),

        // Fruits
        FoodItem("23", "Apple", 52f, 0.3f, 0.2f, 13.8f, 100f),
        FoodItem("24", "Banana", 89f, 1.1f, 0.3f, 22.8f, 100f),
        FoodItem("25", "Orange", 47f, 0.9f, 0.1f, 11.8f, 100f),
        FoodItem("26", "Strawberries", 32f, 0.7f, 0.3f, 7.7f, 100f),
        FoodItem("27", "Grapes", 69f, 0.7f, 0.2f, 18.1f, 100f),
        FoodItem("28", "Mango", 60f, 0.8f, 0.4f, 15.0f, 100f),

        // Vegetables
        FoodItem("29", "Broccoli", 34f, 2.8f, 0.4f, 6.6f, 100f),
        FoodItem("30", "Spinach", 23f, 2.9f, 0.4f, 3.6f, 100f),
        FoodItem("31", "Carrot", 41f, 0.9f, 0.2f, 9.6f, 100f),
        FoodItem("32", "Tomato", 18f, 0.9f, 0.2f, 3.9f, 100f),
        FoodItem("33", "Cucumber", 16f, 0.7f, 0.1f, 3.6f, 100f),
        FoodItem("34", "Cauliflower", 25f, 1.9f, 0.1f, 4.9f, 100f),

        // Nuts & Seeds
        FoodItem("35", "Almonds", 579f, 21.2f, 49.9f, 21.6f, 100f),
        FoodItem("36", "Peanuts", 567f, 25.8f, 49.2f, 16.1f, 100f),
        FoodItem("37", "Chia Seeds", 486f, 16.5f, 30.7f, 42.1f, 100f),
        FoodItem("38", "Flaxseeds", 534f, 18.3f, 42.2f, 28.9f, 100f),

        // Oils & Fats
        FoodItem("39", "Olive Oil", 884f, 0.0f, 100.0f, 0.0f, 100f),
        FoodItem("40", "Butter", 717f, 0.9f, 81.1f, 0.1f, 100f),
        FoodItem("41", "Coconut Oil", 862f, 0.0f, 100.0f, 0.0f, 100f),
        FoodItem("42", "Avocado Oil", 884f, 0.0f, 100.0f, 0.0f, 100f),

        // Sweets & Snacks
        FoodItem("43", "Dark Chocolate (70-85% Cocoa)", 598f, 7.8f, 43.0f, 46.0f, 100f),
        FoodItem("44", "Milk Chocolate", 535f, 7.6f, 30.0f, 61.0f, 100f),
        FoodItem("45", "Potato Chips", 536f, 7.0f, 34.6f, 50.9f, 100f),
        FoodItem("46", "Popcorn (Air-Popped)", 387f, 12.9f, 4.3f, 77.0f, 100f),

        // Beverages
        FoodItem("47", "Coffee (Black)", 1f, 0.1f, 0.0f, 0.0f, 100f),
        FoodItem("48", "Tea (Black)", 1f, 0.1f, 0.0f, 0.0f, 100f),
        FoodItem("49", "Green Tea", 1f, 0.1f, 0.0f, 0.0f, 100f),
        FoodItem("50", "Orange Juice", 45f, 0.7f, 0.2f, 10.4f, 100f),

        FoodItem("51", "Aloo Paratha", 240f, 5f, 10f, 35f, 100f),
        FoodItem("52", "Gobi Paratha", 230f, 5f, 8f, 32f, 100f),
        FoodItem("53", "Paneer Paratha", 260f, 9f, 12f, 28f, 100f),
        FoodItem("54", "Methi Paratha", 210f, 6f, 7f, 30f, 100f),
        FoodItem("55", "Vegetable Upma", 220f, 6f, 10f, 30f, 100f),
        FoodItem("56", "Vegetable Poha", 200f, 5f, 9f, 25f, 100f),
        FoodItem("57", "Sabudana Khichdi", 180f, 3f, 8f, 30f, 100f),
        FoodItem("58", "Masala Dosa", 240f, 6f, 9f, 35f, 100f),
        FoodItem("59", "Plain Dosa", 133f, 2.7f, 4f, 20f, 100f),
        FoodItem("60", "Idli (2 pcs)", 140f, 4f, 1f, 28f, 100f),
        FoodItem("61", "Medu Vada", 180f, 5f, 10f, 20f, 100f),
        FoodItem("62", "Sambar", 90f, 4f, 2f, 15f, 100f),
        FoodItem("63", "Chole Bhature", 350f, 10f, 12f, 45f, 100f),
        FoodItem("64", "Rajma Chawal", 280f, 8f, 7f, 40f, 100f),
        FoodItem("65", "Kadhi Chawal", 220f, 6f, 9f, 30f, 100f),
        FoodItem("66", "Veg Pulao", 210f, 4f, 5f, 35f, 100f),
        FoodItem("67", "Chicken Biryani", 290f, 14f, 12f, 28f, 100f),
        FoodItem("68", "Egg Curry", 180f, 11f, 12f, 6f, 100f),
        FoodItem("69", "Paneer Butter Masala", 293f, 9f, 22f, 10f, 100f),
        FoodItem("70", "Dal Tadka", 120f, 6f, 3f, 15f, 100f),
        FoodItem("71", "Butter Naan", 290f, 6f, 9f, 45f, 100f),
        FoodItem("72", "Tandoori Roti", 150f, 5f, 3f, 25f, 100f),
        FoodItem("73", "Plain Roti", 120f, 3.2f, 2.0f, 20f, 100f),
        FoodItem("74", "Pav Bhaji", 250f, 5f, 14f, 30f, 100f),
        FoodItem("75", "Vada Pav", 290f, 6f, 15f, 32f, 100f),
        FoodItem("76", "Misal Pav", 330f, 9f, 15f, 40f, 100f),
        FoodItem("77", "Omelette", 154f, 11f, 12f, 1f, 100f),
        FoodItem("78", "Egg Bhurji", 170f, 12f, 13f, 2f, 100f),
        FoodItem("79", "Fried Rice (Veg)", 200f, 4f, 6f, 30f, 100f),
        FoodItem("80", "Chowmein (Veg)", 220f, 5f, 8f, 35f, 100f),
        FoodItem("81", "Maggi Noodles", 345f, 7f, 15f, 50f, 100f),
        FoodItem("82", "Spring Roll (Veg)", 180f, 4f, 10f, 22f, 100f),
        FoodItem("83", "Chicken Roll", 290f, 14f, 13f, 30f, 100f),
        FoodItem("84", "Samosa", 260f, 3f, 15f, 30f, 100f),
        FoodItem("85", "Paneer Tikka", 300f, 15f, 20f, 5f, 100f),
        FoodItem("86", "Chicken Tikka", 290f, 20f, 18f, 4f, 100f),
        FoodItem("87", "Kofta Curry", 240f, 8f, 15f, 15f, 100f),
        FoodItem("88", "Methi Malai Murg", 280f, 20f, 18f, 6f, 100f),
        FoodItem("89", "Palak Paneer", 180f, 7f, 12f, 8f, 100f),
        FoodItem("90", "Baingan Bharta", 120f, 3f, 7f, 10f, 100f),
        FoodItem("91", "Mixed Veg Curry", 130f, 4f, 5f, 18f, 100f),
        FoodItem("92", "Kofta (Lauki)", 160f, 5f, 10f, 18f, 100f),
        FoodItem("93", "Chana Masala", 180f, 9f, 6f, 24f, 100f),
        FoodItem("94", "Paneer Bhurji", 250f, 12f, 20f, 8f, 100f),

        FoodItem("95", "Boiled Egg", 155f, 13f, 11f, 1.1f, 100f),
        FoodItem("96", "Egg White (Boiled)", 52f, 11f, 0.2f, 0.7f, 100f),
        FoodItem("97", "Egg Yolk (Boiled)", 322f, 16f, 27f, 3.6f, 100f),

        // Fruits (Raw)
        FoodItem("98", "Apple (Raw)", 52f, 0.3f, 0.2f, 13.8f, 100f),
        FoodItem("99", "Banana (Raw)", 89f, 1.1f, 0.3f, 22.8f, 100f),
        FoodItem("100", "Orange (Raw)", 47f, 0.9f, 0.1f, 11.8f, 100f),
        FoodItem("101", "Papaya (Raw)", 43f, 0.5f, 0.3f, 11f, 100f),
        FoodItem("102", "Watermelon", 30f, 0.6f, 0.2f, 7.6f, 100f),
        FoodItem("103", "Guava", 68f, 2.6f, 1f, 14.3f, 100f),
        FoodItem("104", "Pineapple", 50f, 0.5f, 0.1f, 13.1f, 100f),
        FoodItem("105", "Mango", 60f, 0.8f, 0.4f, 15f, 100f),
        FoodItem("106", "Grapes", 69f, 0.7f, 0.2f, 18.1f, 100f),
        FoodItem("107", "Strawberries", 32f, 0.7f, 0.3f, 7.7f, 100f),
        FoodItem("108", "Pomegranate", 83f, 1.7f, 1.2f, 19f, 100f),
        FoodItem("109", "Pear", 57f, 0.4f, 0.1f, 15f, 100f),

        // Vegetables (Raw / Boiled)
        FoodItem("110", "Boiled Potato", 87f, 1.9f, 0.1f, 20f, 100f),
        FoodItem("111", "Boiled Sweet Potato", 90f, 2f, 0.2f, 21f, 100f),
        FoodItem("112", "Boiled Broccoli", 35f, 2.4f, 0.4f, 7f, 100f),
        FoodItem("113", "Boiled Carrot", 35f, 0.8f, 0.2f, 8.2f, 100f),
        FoodItem("114", "Boiled Green Beans", 31f, 1.8f, 0.1f, 7f, 100f),
        FoodItem("115", "Boiled Cauliflower", 25f, 1.9f, 0.3f, 4.9f, 100f),
        FoodItem("116", "Boiled Spinach", 23f, 2.9f, 0.4f, 3.6f, 100f),
        FoodItem("117", "Raw Tomato", 18f, 0.9f, 0.2f, 3.9f, 100f),
        FoodItem("118", "Cucumber", 16f, 0.7f, 0.1f, 3.6f, 100f),
        FoodItem("119", "Beetroot (Boiled)", 43f, 1.6f, 0.2f, 10f, 100f),
        FoodItem("120", "Green Peas (Boiled)", 84f, 5.4f, 0.4f, 15f, 100f),
        FoodItem("121", "Corn (Boiled)", 96f, 3.4f, 1.5f, 21f, 100f),

        // Other Staples
        FoodItem("122", "Boiled Brown Rice", 111f, 2.6f, 0.9f, 23.0f, 100f),
        FoodItem("123", "Boiled White Rice", 130f, 2.4f, 0.3f, 28f, 100f),
        FoodItem("124", "Boiled Lentils", 116f, 9f, 0.4f, 20f, 100f),
        FoodItem("125", "Boiled Chickpeas", 164f, 8.9f, 2.6f, 27.4f, 100f),
        FoodItem("126", "Boiled Kidney Beans", 127f, 8.7f, 0.5f, 22.8f, 100f),
        FoodItem("127", "Boiled Green Moong", 105f, 7f, 0.5f, 18f, 100f)
    )
}
