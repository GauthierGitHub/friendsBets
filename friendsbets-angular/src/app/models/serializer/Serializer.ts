import { User } from '../user.model';
import { Group } from '../group.model';
import { Message } from '../message.model';

/**
 * Needed for "add" attribute to an instance
 */
export interface TypedObject {
    jsonType: string;
}

export class Serializer {

    /**
     * remove underscore with a RegEx andtransform into JSON 
     * @param o 
     */
    static serializeToJSON(o: Object) {
        //o = this.addJsonType(o);
        return JSON.parse(JSON.stringify(o).replace(/"_/g, '"'));
    }

    static toTypeScriptObject(o) {
        console.log(o);
        
        console.log(JSON.stringify(JSON.parse(o).replace(/,"/g, ',"_')));
        
        // return JSON.stringify(JSON.parse(o).replace(/,"/g, ',"_'))
    }

    /**
     * Required for jackson deserializer
     * https://stackoverflow.com/questions/12710905/how-do-i-dynamically-assign-properties-to-an-object-in-typescript/54445030#54445030
     * @param o 
     */
    private static addJsonType(o: Object): Object{
        let t: TypedObject; 
        o = Object.assign(t = { jsonType: o.constructor.name }, o);
        Object.keys(o).forEach(k => {
            if (o[k] instanceof Object){
                o[k] = Object.assign(t = { jsonType: o[k].constructor.name }, o[k]);
            }
        });
        return o;
    }
    // static serialize<T>(o: T): Object {
    //     return  Object.assign(new Object(), {jsonType: this.objectToString(o)}, this.serializeSubobjects(this.removeUnderscore(o)));
    // }

    // TODO: static deserializer 

    //! My old version

    // static serializeToJSON(o: Object) {
    //     // TODO: add token ?
    //     let stringJson =
    //     {
    //         "nickname": x.nickname,
    //         "password": x.password,
    //         "email": x.email,
    //         "picturePath": null,
    //         "token": null,
    //         "tokenLastUsed": null
    //     }
    //     return stringJson;
    // }

    //! Andre's version

    // private static stringToObject(s: String): Object {
    //     switch (s) {
    //         case "User": return new User();
    //         case "Group": return new Group();
    //         case "Message": return new Message();
    //         default: return new Object();
    //     }
    // }
    // private static objectToString(o: Object): string {
    //     return o.constructor.name;
    // }


    // private static removeUnderscore(o: Object) {
    //     let n: Object = {};
    //     Object.keys(o).forEach(k => n[k.startsWith("_") ? k.substring(1) : k] = o[k] );
    //     return n;
    // }

    static addUnderscore(o: Object) {
        let n: Object = {};
        Object.keys(o).forEach(k => n[k.startsWith("_") ? k : "_" + k] = o[k] );
        return n;
    }

    // private static deserializeSubobjects(o: Object) {
    //     Object.keys(o).forEach(k => {
    //         if (o[k] instanceof Object)
    //             o[k] = this.deserialize(o[k]);
    //     });
    //     return o;
    // }

    // private static serializeSubobjects(o: Object) {
    //     Object.keys(o).forEach(k => {
    //         if (o[k] instanceof Object)
    //             o[k] = this.serialize(o[k]);
    //     });
    //     return o;
    // }

    // static deserialize<T>(o: TypedObject): T {
    //     return Object.assign(this.stringToObject(o.jsonType) as T, this.deserializeSubobjects(this.addUnderscore(o)));
    // }

    // static serialize<T>(o: T): Object {
    //     return  Object.assign(new Object(), {jsonType: this.objectToString(o)}, this.serializeSubobjects(this.removeUnderscore(o)));
    // }



}