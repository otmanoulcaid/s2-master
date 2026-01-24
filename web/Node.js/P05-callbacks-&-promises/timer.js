const timer = {
    pause(time, callback) {
        setTimeout(callback, time);
    },
    promises : {
        pause(time) {
            return new Promise((resolve, reject) => {
                setTimeout(() => {
                    resolve({time, message: 'pause de fonction promise'});
                }, time)
            })
        }
    }
}

export default timer;