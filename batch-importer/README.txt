This tool lets you download all your photos from Flickr and supports restarts and auditability. 
It's very rough and not nearly ready for someone to use if they're not a software programmer: 
you need to first run the 'web' module in this same project (/web). When you run it, go to http://localhost:8080/ and then follow the signin flow.

Once you've done that, check your database (configured in MainConfig)'s userconnection table. In particular, you'll see the accessToken and secret values. Add those to a properties along with the configuration needed to connect to you rbatch database, like this:

#----------------------------------

clientId=Your client ID
clientSecret=your client Secret

accessToken=access Token
accessTokenSecret=access token secret 


dataSource.user=photos
dataSource.db=photos
dataSource.password=photos
dataSource.host=127.0.0.1
dataSource.driverClassName=org.postgresql.Driver
dataSource.port=5432

dataSource.createTables = false
#----------------------------------

Once you have all that, you can run the batch job. The batch job will need the tables contained
in src/main/resources/batch_pg.sql and src/main/resources/photos_pg.sql to work. Once you're done,
simply specify where Spring can find this configuration file in the code for the Main class. By default, the code
looks for <code>~/Desktop/flickr.properties</code>.

