//
//  WatchOSPageTrackBeginCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "WatchOSPageTrackBeginCommand.h"

@implementation WatchOSPageTrackBeginCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *track_begin_str = @"\t// 以Glance为例 \n\
    [TalkingData trackPageBegin:<#页面名称#> withPageType:TDPageTypeGlance];";
    
    [self insertEditableWithInvocation:invocation contents:track_begin_str editPosition:track_begin_str.length + 1];
    
    completionHandler(nil);
}

@end
