import { User } from '../User.model';
import { Group } from '../Group.model';
import { Message } from '../Message.model';
import { ConstructorProvider } from '@angular/core';
import { log } from 'util';

/**
 * Needed for "add" attribute to an instance.
 */
export interface TypedObject {
    jsonType: string;
}

/**
 * Serialize object to JSON.
 * Unserialise JSON to typescript object.
 */
export class Serializer {

    /**
     * remove underscore and transform to JSON.
     * @param o 
     */
    static serializeToJSON(o: Object) {
        o = this.addJsonType(o);
        return JSON.parse(JSON.stringify(o).replace(/"_/g, '"'));
    }


    /**
     * Convert un object class to the right TypeScript class (add underscore).
     * Can't be separate in two functions: T would be read as a value.
     * Needed for transform json to the right TypeScript Object.
     * performance : https://itnext.io/can-json-parse-be-performance-improvement-ba1069951839
     * @param o 
     * @param type TypeScript Class that neede
     */
    static toTypeScriptObject<T>(o: Object, type: (new () => T)): T {
        o = JSON.parse(JSON.stringify(o).replace(/,\\"|{\\"/g, x=> x+"_")); //regEx: ," or {"
        if("picturePath" in o) // TODO: ask where store img
            this.addPicturePath(o);
        console.log(o);
        
        let entity = new type();
        entity = Object.assign(entity, o);
        // add picture pathntity["_picturePath"]){
        //     console.log(entity);
            
        //     console.log("picture path present");
        // }else{
        //     console.log(entity);
        //     console.log("picture path not present");
        // }   
            
        return entity;
    }

    private static addPicturePath(o: Object) {
        // TODO: ask where store img + organize picture
        console.log("picture path");
        console.log(o);
        
        switch (o["jsonType"]) {
            case "User":
                if(o["picturePath"])
                    o["picturePath"] = "assets/img/" + o["picturePath"];
                else
                    o["picturePath"] = "assets/img/avatar.png";
                break;
            case "Group":
                if(o["picturePath"])
                    o["picturePath"] = "assets/img/" + o["picturePath"];
                else
                    o["picturePath"] = "assets/img/group.png";
                break;
            default:
                break;
        }
        console.log(o);        
        // if("picturePath" in o) { // TODO: ask where store img
        //     o["picturePath"] = o["picturePath"] == null ? 
        //         "assets/img/avatar.png" : "assets/img/" + o["picturePath"];   
        // }
    }

    /**
     * Prepare object for webservice.
     * add jsonType k-v, required for jackson deserializer.
     * Can modifie just two level models clusters.
     * TODO: make it more generalist
     * https://stackoverflow.com/questions/12710905/how-do-i-dynamically-assign-properties-to-an-object-in-typescript/54445030#54445030
     * @param o 
     */
    private static addJsonType(o: Object): Object {
        let t: TypedObject;
        o = Object.assign(t = { jsonType: o.constructor.name }, o);
        if(o["IS_MODEL"])
            o["IS_MODEL"] = undefined;
        Object.keys(o).forEach(k => {
            // if (o[k] instanceof Object && !Array.isArray(o[k])) { // avoid "jsontype":"a"
            if (o[k] instanceof Object && o[k]["IS_MODEL"]) { // avoid "jsontype":"Array", "jsontype":"Date" ...
                // add key-value jsonType
                o[k] = Object.assign(t = { jsonType: o[k].constructor.name }, o[k]);
                // remove front-end app key-value
                o[k]["IS_MODEL"] = undefined; 
            }
        });
        return o;
    }

}