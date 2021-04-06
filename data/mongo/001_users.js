// USER DB
db = db.getSiblingDB('sandwichesuserdb'); // like 'use sandwichesuserdb'

db.createUser(
    {
        user: "admin",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "sandwichesuserdb"
            }
        ]
    }
);

db.createCollection('users');

// ORDER DB
db = db.getSiblingDB('sandwichesorderdb'); // like 'use sandwichesorderdb'

db.createUser(
    {
        user: "admin",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "sandwichesorderdb"
            }
        ]
    }
);

db.createCollection('orders');