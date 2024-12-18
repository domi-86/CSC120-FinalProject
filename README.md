# CSC120-FinalProject

## Deliverables:
 - Your final codebase o
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered) o
 - A map of your game's layout (if applicable) o
 - `cheatsheet.md` o
 - Completed `rubric.md` o
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
    - It could have been way better. I spent a lot of time not knowing what I wanted to do, and so I started late compared to everyone I met with. I did spent some time planning it out, and then after getting an idea of the architecture I started coding. Unfortunately I faced so many bugs, and fixing them took up a lot of time, an amount that I underestimated.

 - What **new thing(s)** did you learn / figure out in completing this project?
    - 2D arrays - I had an idea of the concept before but couldn't understand them until I saw that they're "an array of arrays".
      - I learned how to loop through 2D arrays.
    - I learned about the Point class.
      - I also saved myself some time because I can use some of the functions already built in instead of making my own.
    - I learned that enter is just "" and not "\n".
    - I learned how to parse user input in a more complicated way (though not all successfully)

 - Is there anything that you wish you had **implemented differently**?
     - I wish that I had implemented all of the commands relating to the items differently; they're not in the Items class and they probably should be.

 - If you had **unlimited time**, what additional features would you implement?
     - There's several features I planned to implement from the start and just didn't have time for them. Those include: tracking which rooms the player has visited so that only ones they've seen show up on the map, and the description doesn't show every time (like Zork), an actually funcitoning inventory and items system, a bigger map, and challenges.

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
     - My classmates gave me thoughts on how to build the map and I eventually settled on using a 2D array, since my game is inside a house.

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
      - Making the map isn't as hard as you think it is! The hardest part is figuring out how all of the separate parts fit together in code.
      
 - Design justification, includes a discussion of at least one (reasonable) **alternative design** that could have been used, and the reasons why you decided against this alternative.
      - One alternative design I could have used is, like I had planned initially, keeping the inventory methods within the TakeableItem class. I decided to make it a seperate class because it has so many methods. Another alternative is having my program be more object oriented by having take, drop, examine, and use in the Item/TakeableItem class. (I planned to, but ran out of time to change it.)
