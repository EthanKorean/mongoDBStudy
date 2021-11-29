cd C:\Program Files\MongoDB\Server\5.0\bin

mongo.exe mongo_study --eval "db.user.drop()"
mongo.exe mongo_study --eval "db.board.drop()"

mongo.exe mongo_study --eval "db.user.insert({login_id:'admin',pwd:'admin',email:'',phone:'',mobile:'',status:'',create_dt:'',modify_dt:'',end_dt:''});"
mongo.exe mongo_study --eval "db.board.insert({title:'',content:'',writer:'',create_dt:'',modify_dt:'',end_dt:''});"

pause