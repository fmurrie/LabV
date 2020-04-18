Questions and answers:

-> How many consumers are needed for the stock gets to 0?
    The system only needs one consumer.

-> Blocks synchronized for what?
    Because the beer house is a shared resource by the threads consumers and producters.
    
-> Explain the shared resource
    The beer house contains the stock of beers and the max capacity for have in it.
    The producter can puts beers if the stock is less than the limit and the consumer can takes
    beers if are in stock.
    
-> Differents ways of instance a thread:
    .Extends of the class Thread
    .Implements the interface IRunneable
    .new Thread();