package com.example.fitnessapp.main_pages.workout_pages

object ExerciseRepository {
    val exerciseList = listOf(
        Exercise(
            1,
            "Dumbbell Incline Fly (Chest)",
            "WorkoutExercises/03191201-Dumbbell-Incline-Fly_Chest.mp4",
            "Targets the upper chest muscles by isolating the pectorals. Great for enhancing chest width and strength.",
            0.45f
        ),
        Exercise(
            2,
            "Dumbbell Incline Row (Back)",
            "WorkoutExercises/03271201-Dumbbell-Incline-Row_Back.mp4",
            "Strengthens the upper back and posterior deltoids, improving posture and back definition.",
            0.4f
        ),
        Exercise(
            3,
            "Dumbbell Lateral Raise (Shoulders)",
            "WorkoutExercises/03341201-Dumbbell-Lateral-Raise_shoulder.mp4",
            "Focuses on the lateral deltoid to build broader and stronger shoulders.",
            0.5f
        ),
        Exercise(
            4,
            "Dumbbell Lunge (Hips)",
            "WorkoutExercises/03361201-Dumbbell-Lunge_Hips.mp4",
            "Targets glutes, quads, and hamstrings. Enhances balance, stability, and hip strength.",
            0.6f
        ),
        Exercise(
            5,
            "Dumbbell Reverse Fly (Shoulders)",
            "WorkoutExercises/03831201-Dumbbell-Reverse-Fly_Shoulders.mp4",
            "Works the rear deltoids and upper back, improving shoulder stability and posture.",
            0.5f
        ),
        Exercise(
            6,
            "Dumbbell Seated Shoulder Press (Shoulders)",
            "WorkoutExercises/04051201-Dumbbell-Seated-Shoulder-Press_Shoulders.mp4",
            "Builds strength in the deltoids and triceps while minimizing lower back strain.",
            0.55f
        ),
        Exercise(
            7,
            "Front Plank (Waist/Core)",
            "WorkoutExercises/04631201-Front-Plank-m_waist.mp4",
            "Core stabilization exercise that strengthens the abs, lower back, and shoulders.",
            0.3f
        ),
        Exercise(
            8,
            "Lever Chest Press (Plate Loaded) (Chest)",
            "WorkoutExercises/05761201-Lever-Chest-Press-(plate-loaded)_Chest.mp4",
            "Machine-based chest press that allows safe, controlled resistance for pectoral development.",
            0.4f
        ),
        Exercise(
            9,
            "Lever Chest Press (Chest)",
            "WorkoutExercises/05771201-Lever-Chest-Press_Chest.mp4",
            "Helps in targeting the mid and lower chest with guided motion, reducing injury risk.",
            0.4f
        ),
        Exercise(
            10,
            "Lever Front Pulldown (Back)",
            "WorkoutExercises/05791201-Lever-Front-Pulldown_Back.mp4",
            "Isolates the lats and biceps, perfect for building a wider and stronger back.",
            0.5f
        ),
        Exercise(
            11,
            "Lever Lateral Raise (Shoulders)",
            "WorkoutExercises/05841201-Lever-Lateral-Raise_shoulder.mp4",
            "Targets the side deltoid muscles to improve shoulder width and upper body aesthetics.",
            0.5f
        ),
        Exercise(
            12,
            "Lever Leg Extension (Thighs)",
            "WorkoutExercises/05851201-Lever-Leg-Extension_Thighs.mp4",
            "Isolates the quadriceps, ideal for leg muscle growth and knee joint strengthening.",
            0.6f
        ),
        Exercise(
            13,
            "Lever Lying Leg Curl (Thighs)",
            "WorkoutExercises/05861201-Lever-Lying-Leg-Curl_Thighs.mp4",
            "Targets the hamstrings, helping in muscle balance and lower body injury prevention.",
            0.6f
        ),
        Exercise(
            14,
            "Lever Fly (Chest)",
            "WorkoutExercises/05961201-Lever-Fly_Chest.mp4",
            "Isolates the chest muscles, enhancing chest definition and stretch-contraction strength.",
            0.45f
        ),
        Exercise(
            15,
            "Lever Seated Leg Curl (Thighs)",
            "WorkoutExercises/05991201-Lever-Seated-Leg-Curl_Thighs.mp4",
            "Works the hamstrings in a seated position to build balanced leg strength.",
            0.6f
        ),
        Exercise(
            16,
            "Lever Seated Reverse Fly (Shoulders)",
            "WorkoutExercises/06021201-Lever-Seated-Reverse-Fly_Shoulders.mp4",
            "Great for rear deltoid and upper back development. Improves posture and stability.",
            0.5f
        ),
        Exercise(
            17,
            "Lever Standing Calf Raise (Calves)",
            "WorkoutExercises/06051201-Lever-Standing-Calf-Raise_Calves.mp4",
            "Strengthens the gastrocnemius and soleus muscles for stronger and larger calves.",
            0.4f
        ),
        Exercise(
            18,
            "Pull-up (Back)",
            "WorkoutExercises/06251201-Pull-up_Back.mp4",
            "Classic compound exercise for upper body strength, focusing on lats and biceps.",
            0.7f
        ),
        Exercise(
            19,
            "Push-up (Chest/Core)",
            "WorkoutExercises/06821201-Push-up_m_Chest.mp4",
            "Bodyweight movement that activates chest, triceps, and core for overall strength.",
            0.6f
        ),
        Exercise(
            20,
            "Russian Twist (Waist/Core)",
            "WorkoutExercises/06871201-Russian-Twist_waist.mp4",
            "Great rotational core exercise for strengthening obliques and improving core definition.",
            0.4f
        ),
        Exercise(
            21,
            "Side Plank (Waist/Core)",
            "WorkoutExercises/07151201-Side-Plank-m_Waist.mp4",
            "Improves core stability, especially the obliques. Also helps enhance spinal alignment and balance.",
            0.3f
        ),
        Exercise(
            22,
            "Sled 45 Calf Press (Calves)",
            "WorkoutExercises/07381201-Sled-45-Calf-Press_Calves.mp4",
            "Targets the calf muscles under heavy load for improved size and strength.",
            0.5f
        ),
        Exercise(
            23,
            "Sled 45 Leg Press (Hips/Thighs)",
            "WorkoutExercises/07391201-Sled-45-Leg-Press_Hips.mp4",
            "Develops lower body power focusing on glutes, quads, and hamstrings in a safe manner.",
            0.6f
        ),
        Exercise(
            24,
            "Smith Back Shrug (Back/Traps)",
            "WorkoutExercises/07461201-Smith-Back-Shrug-Back.mp4",
            "Isolates the trapezius muscles to build a stronger, thicker upper back.",
            0.5f
        ),
        Exercise(
            25,
            "Smith Bench Press (Chest)",
            "WorkoutExercises/07481201-Smith-Bench-Press_Chest.mp4",
            "A stable and safe way to develop chest and triceps strength using guided bar path.",
            0.5f
        ),
        Exercise(
            26,
            "Smith Incline Bench Press (Upper Chest)",
            "WorkoutExercises/07501201-Smith-Incline-Bench-Press_Chest.mp4",
            "Targets the upper chest and shoulders to build upper pec mass with added stability.",
            0.5f
        ),
        Exercise(
            27,
            "Trap Bar Deadlift (Thighs/Hips/Back)",
            "WorkoutExercises/08111201-Trap-Bar-Deadlift_Thighs.mp4",
            "A compound lift that builds strength in legs, hips, and lower back with less strain on the spine.",
            0.8f
        ),
        Exercise(
            28,
            "Wheel Rollout (Core)",
            "WorkoutExercises/08571201-Wheel-Rollout_Waist.mp4",
            "Intense core exercise that strengthens the abs, shoulders, and lower back.",
            0.5f
        ),
        Exercise(
            29,
            "Cable Twist (Up-Down) (Waist/Core)",
            "WorkoutExercises/08621201-Cable-twist-(up-down)_Waist.mp4",
            "Great for rotational core strength, targeting the obliques and improving torso mobility.",
            0.4f
        ),
        Exercise(
            30,
            "Lever Pec Deck Fly (Chest)",
            "WorkoutExercises/09210201-Lever-Pec-Deck-Fly_Chest.mp4",
            "A chest isolation exercise that emphasizes pectoral contraction and stretch.",
            0.45f
        ),
        Exercise(
            31,
            "Sumo Squat (Thighs/Glutes)",
            "WorkoutExercises/10641201-Sumo-Squat-(male)-Thighs-FIX_.mp4",
            "Targets inner thighs and glutes more than a regular squat. Enhances hip mobility.",
            0.7f
        ),
        Exercise(
            32,
            "Burpee (Cardio/Full Body)",
            "WorkoutExercises/11601201-Burpee_Cardio.mp4",
            "High-intensity full-body movement that improves cardiovascular endurance and explosive strength.",
            1.0f
        ),
        Exercise(
            33,
            "Smith Calf Raise (Version 2) (Calves)",
            "WorkoutExercises/11641201-Smith-Calf-Raise-(version-2)_Calves.mp4",
            "Isolates and strengthens calf muscles with controlled resistance on a Smith machine.",
            0.5f
        ),
        Exercise(
            34,
            "Barbell Standing Military Press (Shoulders)",
            "WorkoutExercises/11651201-Barbell-Standing-Military-Press-(without-rack)_Shoulders.mp4",
            "A compound shoulder movement that also engages core and triceps for upper body power.",
            0.6f
        ),
        Exercise(
            35,
            "Smith Standing Shoulder Press (Shoulders)",
            "WorkoutExercises/12241201-Smith-Standing-Shoulder-Press_Shoulders.mp4",
            "Focuses on anterior deltoids using the Smith machine for guided and safe overhead pressing.",
            0.55f
        ),
        Exercise(
            36,
            "Flutter Kicks (Hips/Core)",
            "WorkoutExercises/12411201-Flutter-Kicks-(version-3)_Hips.mp4",
            "Strengthens the lower abs and hip flexors. Great for endurance and core stability.",
            0.35f
        ),
        Exercise(
            37,
            "Cable Standing Up Straight Crossovers (Chest)",
            "WorkoutExercises/12641201-Cable-Standing-Up-Straight-Crossovers_Chest.mp4",
            "A cable-based chest fly variation that offers constant tension for inner chest activation.",
            0.45f
        ),
        Exercise(
            38,
            "Cable Front Raise (Shoulders)",
            "WorkoutExercises/12961201-Cable-Front-Raise_Shoulders.mp4",
            "Targets the front deltoid with consistent resistance throughout the range of motion.",
            0.5f
        ),
        Exercise(
            39,
            "Bench Dip on Floor (Triceps/Upper Arms)",
            "WorkoutExercises/13961201-Bench-dip-on-floor_Upper-Arms.mp4",
            "Bodyweight exercise for triceps and shoulders. Improves arm strength and tone.",
            0.45f
        ),
        Exercise(
            40,
            "Dumbbell Romanian Deadlift (Hips/Hamstrings)",
            "WorkoutExercises/14591201-Dumbbell-Romanian-Deadlift_Hips.mp4",
            "Excellent for strengthening hamstrings, glutes, and improving hip hinge mechanics.",
            0.7f
        ),
        Exercise(
            41,
            "Lever Incline Chest Press (Chest)",
            "WorkoutExercises/14791201-Lever-Incline-Chest-Press_Chest.mp4",
            "Targets the upper portion of the chest with guided movement, reducing injury risk while maximizing upper pec activation.",
            0.5f
        ),
        Exercise(
            42,
            "Dumbbell Walking Lunges (Thighs/Glutes)",
            "WorkoutExercises/15571201-Dumbbell-Walking-Lunges_Thighs.mp4",
            "A dynamic leg exercise that strengthens quads, hamstrings, and glutes while improving balance and coordination.",
            0.65f
        ),
        Exercise(
            43,
            "Hanging Leg Hip Raise (Waist/Core)",
            "WorkoutExercises/17641201-Hanging-Leg-Hip-Raise_Waist.mp4",
            "Engages lower abs and hip flexors. Builds a strong, defined core and enhances lower body control.",
            0.4f
        ),
        Exercise(
            44,
            "Hyperextension (Version 2) (Hips/Lower Back)",
            "WorkoutExercises/18601201-Hyperextension-(VERSION-2)_Hips.mp4",
            "Strengthens the erector spinae, glutes, and hamstrings—excellent for posture and back health.",
            0.5f
        ),
        Exercise(
            45,
            "Weighted Decline Crunch (Waist/Abs)",
            "WorkoutExercises/21301201-Weighted-decline-crunch_Waist.mp4",
            "Adds resistance to traditional crunches for enhanced abdominal development and core strength.",
            0.4f
        ),
        Exercise(
            46,
            "Lever Rotary Calf (Calves)",
            "WorkoutExercises/23151201-Lever-Rotary-Calf_Calves.mp4",
            "Targets the soleus and gastrocnemius muscles in the calves through controlled rotary movement.",
            0.4f
        ),
        Exercise(
            47,
            "Cable Seated Row with V-Bar (Back)",
            "WorkoutExercises/26611201-Cable-Seated-Row-with-V-bar_Back.mp4",
            "Focuses on building thickness in the middle back while also engaging lats and biceps with constant cable resistance.",
            0.5f
        ),
        Exercise(
            48,
            "Dumbbell Incline Y Raise (Shoulders)",
            "WorkoutExercises/35411201-Dumbbell-Incline-Y-Raise_Shoulders.mp4",
            "Great for isolating the lower traps and rear deltoids, helping correct shoulder posture and balance.",
            0.45f
        ),
        Exercise(
            49,
            "Incline Push-Up (on box) (Chest/Shoulders)",
            "WorkoutExercises/37851201-Incline-Push-Up-(on-box).mp4",
            "Beginner-friendly chest exercise that reduces pressure on shoulders while targeting upper chest muscles.",
            0.4f
        ),
        Exercise(
            50,
            "Dumbbell Incline Fly (Chest)",
            "WorkoutExercises/03191201-Dumbbell-Incline-Fly_Chest.mp4",
            "Performed on an incline bench, this isolation exercise focuses on stretching and contracting the upper chest (clavicular pectoralis). It promotes muscle definition and upper chest mass.",
            0.45f
        ),
        Exercise(
            51,
            "Dumbbell Incline Bench Press (Chest)",
            "WorkoutExercises/03141201-Dumbbell-Incline-Bench-Press_Chest.mp4",
            "This pressing motion primarily targets the upper pectorals and front deltoids. The incline position shifts focus from mid to upper chest, enhancing upper body thickness.",
            0.55f
        ),
        Exercise(
            52,
            "Dumbbell Hammer Curl (Version 2) (Upper Arms)",
            "WorkoutExercises/03121201-Dumbbell-Hammer-Curl-(version-2)_Upper-Arms.mp4",
            "Emphasizes the brachialis muscle beneath the biceps. This variation enhances arm width and works the forearms too.",
            0.50f
        ),
        Exercise(
            53,
            "Dumbbell Front Raise (Shoulders)",
            "WorkoutExercises/03101201-Dumbbell-Front-Raise_Shoulders.mp4",
            "Targets the anterior deltoid, helping develop the front portion of the shoulders. A key movement for shoulder symmetry and posture.",
            0.40f
        ),
        Exercise(
            54,
            "Dumbbell Fly (Chest)",
            "WorkoutExercises/03081201-Dumbbell-Fly_Chest.mp4",
            "Classic isolation movement for the chest. It works by stretching the pectoral muscles under load and then contracting for a full range of motion.",
            0.45f
        ),
        Exercise(
            55,
            "Dumbbell Decline Fly (Chest)",
            "WorkoutExercises/03021201-Dumbbell-Decline-Fly_Chest.mp4",
            "Performed on a decline bench to target the lower portion of the chest. Ideal for improving chest depth and aesthetics.",
            0.45f
        ),
        Exercise(
            56,
            "Dumbbell Concentration Curl (Upper Arms)",
            "WorkoutExercises/02971201-Dumbbell-Concentration-Curl_Upper-Arms.mp4",
            "Performed seated, this highly focused biceps movement reduces momentum, isolating the muscle for peak contraction and size gains.",
            0.50f
        ),
        Exercise(
            57,
            "Dumbbell Biceps Curl (Upper Arms)",
            "WorkoutExercises/02941201-Dumbbell-Biceps-Curl_Upper-Arms.mp4",
            "A foundational arm exercise that targets both the long and short heads of the biceps. Essential for building arm strength and size.",
            0.50f
        ),
        Exercise(
            58,
            "Dumbbell Bent Over Row (Back)",
            "WorkoutExercises/02931201-Dumbbell-Bent-Over-Row_Back.mp4",
            "A compound lift that develops the lats, traps, and rhomboids. Improves posture and back thickness while also engaging core stabilizers.",
            0.55f
        ),
        Exercise(
            59,
            "Dumbbell Bench Press (Chest)",
            "WorkoutExercises/02891201-Dumbbell-Bench-Press_Chest.mp4",
            "A versatile chest-building exercise that also activates shoulders and triceps. Provides better range of motion than barbell presses.",
            0.55f
        ),
        Exercise(
            60,
            "Decline Push-Up (Chest)",
            "WorkoutExercises/02791201-Decline-Push-Up_Chest.mp4",
            "A bodyweight movement with feet elevated to increase load on upper chest and front shoulders. Excellent for home workouts.",
            0.32f
        ),
        Exercise(
            61,
            "Decline Crunch (Waist)",
            "WorkoutExercises/02771201-Decline-Crunch_Waist.mp4",
            "Targets upper abs more intensively due to the decline angle. Adds resistance and gravity to core training.",
            0.25f
        ),
        Exercise(
            62,
            "Crunch Floor (Waist)",
            "WorkoutExercises/02741201-Crunch-Floor-m_waist.mp4",
            "Basic but effective abdominal exercise focused on isolating the rectus abdominis. Can be done without equipment.",
            0.25f
        ),
        Exercise(
            63,
            "Close Grip Push-up (Upper Arms)",
            "WorkoutExercises/02591201-Close-Grip-Push-up_Upper-Arms.mp4",
            "A push-up variation that emphasizes the triceps over chest. Great for upper arm development with bodyweight.",
            0.32f
        ),
        Exercise(
            64,
            "Chest Dip (Chest)",
            "WorkoutExercises/02511201-Chest-Dip_Chest.mp4",
            "Targets lower chest and triceps using bodyweight. Leaning forward activates more chest fibers. Ideal for upper body strength.",
            0.55f
        ),
        Exercise(
            65,
            "Cable Pushdown (Upper Arms)",
            "WorkoutExercises/02011201-Cable-Pushdown_Upper-Arms.mp4",
            "Uses a cable machine to isolate the triceps. A controlled movement that’s excellent for building arm definition.",
            0.40f
        ),
        Exercise(
            66,
            "Cable One Arm Lateral Raise (Shoulders)",
            "WorkoutExercises/01921201-Cable-One-Arm-Lateral-Raise_Shoulders.mp4",
            "Builds the lateral deltoid with consistent resistance. Great for improving shoulder width and symmetry.",
            0.45f
        ),
        Exercise(
            67,
            "Cable Low Seated Row (Back)",
            "WorkoutExercises/01801201-Cable-Low-Seated-Row_Back.mp4",
            "A controlled row that targets mid and upper back. Constant tension helps with back density and posture.",
            0.50f
        ),
        Exercise(
            68,
            "Cable Kneeling Crunch (Waist)",
            "WorkoutExercises/01751201-Cable-Kneeling-Crunch_Waist.mp4",
            "Strengthens the rectus abdominis through cable resistance. Kneeling variation reduces lower back strain.",
            0.30f
        ),
        Exercise(
            69,
            "Cable Bar Lateral Pulldown (Back)",
            "WorkoutExercises/01501201-Cable-Bar-Lateral-Pulldown_Back.mp4",
            "Effective for lat development with wide grip and vertical pull. Helps build the coveted ‘V’ shape.",
            0.50f
        ),
        Exercise(
            70,
            "Battling Ropes (Full Body)",
            "WorkoutExercises/01281201-Battling-Ropes.mp4",
            "Explosive, high-intensity movement that improves cardiovascular endurance, grip strength, and total body conditioning.",
            1.00f
        ),
        Exercise(
            71,
            "Cable Straight Arm Pulldown (Back)",
            "WorkoutExercises/01511201-Cable-Straight-Arm-Pulldown_Back.mp4",
            "Isolates the lats while minimizing bicep involvement. Great for sculpting back width.",
            0.45f
        ),
        Exercise(
            72,
            "Barbell Sumo Deadlift (Hips)",
            "WorkoutExercises/01171201-Barbell-Sumo-Deadlift_Hips.mp4",
            "A wide-stance deadlift that targets the inner thighs, glutes, hamstrings, and lower back. Ideal for reducing spinal strain while increasing lower-body strength.",
            0.65f
        ),
        Exercise(
            73,
            "Barbell Shrug (Back/Traps)",
            "WorkoutExercises/00951201-Barbell-Shrug_Back.mp4",
            "Targets the upper trapezius muscles. Builds upper back and neck mass, improving shoulder stability and posture.",
            0.40f
        ),
        Exercise(
            74,
            "Barbell Reverse Curl (Forearms)",
            "WorkoutExercises/00801201-Barbell-Reverse-Curl_Forearm.mp4",
            "Isolates the brachioradialis and forearms. Helps enhance grip strength and arm aesthetics.",
            0.45f
        ),
        Exercise(
            75,
            "Barbell Preacher Curl (Upper Arms)",
            "WorkoutExercises/00701201-Barbell-Preacher-Curl_Upper-Arms.mp4",
            "Performs strict biceps work on a preacher bench to isolate the muscle and reduce momentum for size and peak.",
            0.50f
        ),
        Exercise(
            76,
            "Barbell Lunge (Thighs)",
            "WorkoutExercises/00541201-Barbell-Lunge_Thighs.mp4",
            "A compound exercise that targets quads, hamstrings, and glutes. Improves unilateral strength, balance, and coordination.",
            0.65f
        ),
        Exercise(
            77,
            "Barbell Incline Bench Press (Chest)",
            "WorkoutExercises/00471201-Barbell-Incline-Bench-Press_Chest.mp4",
            "Emphasizes upper chest and anterior deltoids. Essential for adding upper body mass and strength.",
            0.60f
        ),
        Exercise(
            78,
            "Barbell Full Squat (Thighs)",
            "WorkoutExercises/00431201-Barbell-Full-Squat_Thighs.mp4",
            "Full range of motion squat targeting quads, glutes, and hamstrings. Builds total lower-body power and joint mobility.",
            0.70f
        ),
        Exercise(
            79,
            "Barbell Front Squat (Hips/Thighs)",
            "WorkoutExercises/00421201-Barbell-Front-Squat_Hips.mp4",
            "Places the bar in front to shift load onto quads and core. Promotes upright posture and stronger anterior chain development.",
            0.68f
        ),
        Exercise(
            80,
            "Barbell Front Raise (Shoulders)",
            "WorkoutExercises/00411101-Barbell-Front-Raise_Shoulders.mp4",
            "Targets the anterior deltoids using a barbell. Builds shoulder size and stability for pressing movements.",
            0.45f
        ),
        Exercise(
            81,
            "Barbell Decline Bench Press (Chest)",
            "WorkoutExercises/00331201-Barbell-Decline-Bench-Press_Chest.mp4",
            "Focuses on the lower portion of the chest. Allows heavier lifts with reduced shoulder strain.",
            0.60f
        ),
        Exercise(
            82,
            "Barbell Deadlift (Hips/Back)",
            "WorkoutExercises/00321201-Barbell-Deadlift_Hips-FIX.mp4",
            "Full-body compound movement that primarily works glutes, hamstrings, and lower back. Essential for power and strength training.",
            0.70f
        ),
        Exercise(
            83,
            "Barbell Curl (Upper Arms)",
            "WorkoutExercises/00311201-Barbell-Curl_Upper-Arms.mp4",
            "Classic mass-building biceps curl using a barbell. Engages both bicep heads and allows progressive overload.",
            0.50f
        ),
        Exercise(
            84,
            "Barbell Close Grip Bench Press (Upper Arms)",
            "WorkoutExercises/00301201-Barbell-Close-Grip-Bench-Press_Upper-Arms.mp4",
            "Targets the triceps and inner chest. Close hand placement shifts emphasis away from shoulders.",
            0.55f
        ),
        Exercise(
            85,
            "Barbell Bent Over Row (Back)",
            "WorkoutExercises/00271201-Barbell-Bent-Over-Row_Back.mp4",
            "Builds thickness in the mid and upper back, with secondary engagement in biceps and rear delts.",
            0.60f
        ),
        Exercise(
            86,
            "Barbell Bench Press (Chest)",
            "WorkoutExercises/00251201-Barbell-Bench-Press_Chest.mp4",
            "One of the most effective compound lifts for overall upper body mass. Primarily works chest, with help from shoulders and triceps.",
            0.60f
        ),
        Exercise(
            87,
            "Assisted Pull-up (Back)",
            "WorkoutExercises/00171201-Assisted-Pull-up_Back.mp4",
            "Back-focused pull-up with assistance for beginners or higher reps. Engages lats, biceps, and core stabilizers.",
            0.45f
        ),
        Exercise(
            88,
            "Assisted Chest Dip (Kneeling) (Chest)",
            "WorkoutExercises/00091201-Assisted-Chest-Dip-(kneeling)_Chest.mp4",
            "Chest and triceps-focused dip using machine or band assistance. Reduces body weight strain and improves form.",
            0.50f
        ),
        Exercise(
            89,
            "3/4 Sit-Up (Waist)",
            "WorkoutExercises/00011201-3-4-Sit-up_Waist.mp4",
            "A controlled sit-up stopping before full flexion. Keeps core under tension and reduces spine strain.",
            0.28f
        )
    )
}


