import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {catchError, map, tap} from 'rxjs/operators';
import {ResponseWrapper} from './../entities/wrappers/response-wrapper';
import {environment} from '../../environments/environment';

@Injectable()
export class StewardServiceService<T, E> {

    private serverUrl: string;

    constructor(private http: HttpClient) {
        this.serverUrl = environment.serverUrl;
    }

    /**
       * Used to handle http post requests with json
       */
    postJson(endpoint: string, data: T): Observable<ResponseWrapper<E>> {
        return this.http.post(this.serverUrl + endpoint, JSON.stringify(data), {
            headers: new HttpHeaders({
                'Content-Type': 'application/json; charset=utf-8'
            })
        }).pipe(
            catchError(this.handleError<any>())
            );
    }
    /**
     * Used to handle http post request with form data
     */
    postFormData(endpoint: string, data: T): Observable<ResponseWrapper<E>> {
        const formData: FormData = new FormData();
        Object.keys(data).forEach((key) => {
            formData.append(key, data[key]);
        });
        return this.http.post(this.serverUrl + endpoint, formData, { headers: new HttpHeaders({ 'Authorization': 'Bearer ' + localStorage.getItem('access_token') }) }).pipe(
            catchError(this.handleError<any>())
        );
    }
    /**
     * Used to catch exception thrown by http client returns internal server error
     * if status 500 is encountered
     */
    private handleError<ResponseWrapper>() {
        return (error: HttpErrorResponse): Observable<any> => {
            const res = new ResponseWrapper();
            //            console.error(error); // log to console instead
            if (error.status == 500) {
                res.code = error.status;
                res.message = 'Sorry internal server error occured please try again later';
            } else {
                res.code = error.status;
                res.message = error.error.message;
                res.data = error.error.data;
            }
            return of(res);
        };
    }

}
