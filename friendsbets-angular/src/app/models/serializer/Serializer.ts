import { User } from '../user.model';
import { Group } from '../group.model';
import { Message } from '../message.model';
import { ConstructorProvider } from '@angular/core';
import { log } from 'util';

/**
 * Needed for "add" attribute to an instance
 */
export interface TypedObject {
    jsonType: string;
}

/**
 * Serialize object to JSON
 * Unserialise JSON to typescript object
 */
export class Serializer {

    /**
     * remove underscore and transform to JSON
     * @param o 
     */
    static serializeToJSON(o: Object) {
        o = this.addJsonType(o);
        return JSON.parse(JSON.stringify(o).replace(/"_/g, '"'));
    }


    /**
     * Convert un object class to the right TypeScript class (add underscore)
     * Can't be separate in two functions: T would be read as a value
     * Needed for transform json to the right TypeScript Object
     * performance : https://itnext.io/can-json-parse-be-performance-improvement-ba1069951839
     * @param o 
     * @param type TypeScript Class that 
     */
    static toTypeScriptObject<T>(o: Object, type: (new () => T)): T {
        o = JSON.parse(JSON.stringify(o).replace(/,\\"|{\\"/g, x=> x+"_")); //regEx: ," or {"
        let entity = new type();
        entity = Object.assign(entity, o);
        return entity;
    }

    /**
     * Prepare object for webservice
     * Required for jackson deserializer
     * https://stackoverflow.com/questions/12710905/how-do-i-dynamically-assign-properties-to-an-object-in-typescript/54445030#54445030
     * @param o 
     */
    private static addJsonType(o: Object): Object {
        let t: TypedObject;
        o = Object.assign(t = { jsonType: o.constructor.name }, o);
        Object.keys(o).forEach(k => {
            if (o[k] instanceof Object && !Array.isArray(o[k])) { // avoid "jsontype":"Array"
                o[k] = Object.assign(t = { jsonType: o[k].constructor.name }, o[k]);
            }
        });
        return o;
    }

}