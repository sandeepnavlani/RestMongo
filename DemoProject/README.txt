Windows Step to create mongo database:-
1.Please install on windows 

2.After install on c:\program files\mongoDB

3. open command prompt execute below command:-
mongod

4. open second command prompt execute below command:-
mongo

5.after following step 4 execute below command:-
use productdetails

6.After completion step 5 execute below command:-

db.price.insert({"_id" : "15117729","id" : "15117729","value" : 16.50,"currency_Code" : "USD"})
db.price.find({"_id" : "15117729"})

7.After completion of above steps we can update the price in price collection.