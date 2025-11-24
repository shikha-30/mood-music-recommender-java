# mood-music-recommender-java
# Introduction
Music is something that helps us to connect with different types of situations that we are going through. we listen different types of music which is based on our mood or you can say that which depends on how we are feeling at that time. When we are sad, we tend to listen songs that give us calmness or songs that are slow, same with when someone is going through heartbreak, they like to listen something that are based on their situation. So, the idea of this project is to create something that helps us to find songs based on our mood named as Mood music recommender in Java.

It is a simple program which suggests songs based on the mood of user. This program also allows user to add their own songs and saved in under favourite file and they can view it.
A small mood detection feature is also included where the system reads a sentence and based on that it will recommend songs
 
# Problem definition 
There are many people who find it difficult to find the right music according to their mood and they waste a lot of time while finding that particular song that is based on their current situation so this program will help them to find it by: 
simply asking the user about their mood 
then the system will suggest them songs according to their mood 
they can also add their own song
user can also save songs into favourites 
system can guess mood from the sentence 

# Objectives 
The main objectives of this program:
To suggest songs according to the user mood
Let users add their own songs 
Save the songs into favourite file 
Detect mood of user from a sentence 

# Project structure: 
/src
    Mood music recommender.java 
Favourites.txt
README.md

# Requirement analysis 
Java development kit 
IntelliJ IDEA or any java IDE platform will work 
windows, MacOS, Linux 

# Algorithm 
All the program is based on simple java concepts 
Algorithm for mood detection: 
1. read the sentence that is provided by the user 
2. convert it into lowercase 
3. now check for keywords like 
sad: - lonely, cry, hurt, etc 
happy: - enjoy, fun, excited, etc 
energetic: - power, gym, hype, etc 
romantic: - love, heart, beautiful, etc 
chill: - peace, calm, relax 
4. match the sentence that user gave to the keywords 
5. return detected mood 

# How to run it:
Open the project in intellIJ or any java IDE will work 
Now go to the src folder
Run the MoodmusicRecommender.java file 
Follow the instructions that are present on the screen after running the file

# Testing 
The program is properly tested if the user enters songs based on mood and then write sad it displayed the songs which are categorised under it 
When used want to save song it is saved in favourites.txt 
when user enters sentence like "I feel happy today" -> mood detected: happy 

# Conclusion
Mood music recommender is a simple java program which helps me to revise many basics concepts of Java like HashMap, lists etc 
It helps user to find the right songs according to their mood
