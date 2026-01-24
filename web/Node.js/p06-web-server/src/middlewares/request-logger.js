// midleware personaliser

export function requestLogger(req, res, next) {
    console.log('>> HTPP Request ' + req.method + ' ' + req.url,
        'query : ' + req.query,
        'params : ' + req.params,
        'headers : ' + req.headers,
        'body : ' + req.body,
        'body : ' + req.body,
    );
    next();
}