
/**
 * Module dependencies.
 */

var express = require('express')
  , routes = require('./routes')
  , user = require('./routes/user')
  , http = require('http')
  , path = require('path');

var mysql = require('mysql');
var connection = mysql.createConnection({
    host    :'localhost',
    port : 3306,
    user : 'study2',
    password : 'study',
    database:'studydb'
});

connection.connect(function(err) {
    if (err) {
        console.error('mysql connection error');
        console.error(err);
        throw err;
    }
});


var app = express();

// all environments
app.set('port', process.env.PORT || 3000);
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.use(express.favicon());
app.use(express.logger('dev'));
app.use(express.bodyParser());
app.use(express.methodOverride());
app.use(app.router);
app.use(express.static(path.join(__dirname, 'public')));





/*app.get('/users', function(req,res){
    var query = connection.query('select * from MEMBERS',function(err,rows){
        console.log(rows);
        res.json(rows);
    });
    console.log(query);
});*/


app.get('/idCheck', function (request, response) {
	response.setHeader("Access-Control-Allow-Origin", "*");
	connection.query('SELECT EMAIL FROM MEMBERS WHERE EMAIL=?', [request.param('id')], function (error, result) {

    	console.log(result);
    	
    	if(result.length){
    		console.log('아이디 있음!!!');	
    		response.send({
    			"result":"이메일이 이미 존재해ㅠㅠ"
    		});
    	}else{
    		console.log('아이디 없음ㅠㅠㅠ');
    		response.send({
    			"result":"그 이메일로 만들어두 댐!!"
    		});
    	}
    });
});





// development only
if ('development' == app.get('env')) {
  app.use(express.errorHandler());
}

app.get('/', routes.index);
app.get('/users', user.list);

http.createServer(app).listen(app.get('port'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});
